package io.natron.noscope360.analyze.service;

import io.natron.noscope360.analyze.model.dto.*;
import io.natron.noscope360.analyze.model.entity.Municipality;
import io.natron.noscope360.analyze.model.entity.QualitativeData;
import io.natron.noscope360.analyze.model.entity.QuantitativeData;
import io.natron.noscope360.analyze.model.entity.IdentifiableValue;
import io.natron.noscope360.analyze.model.indicator.ScaleMappingDelegator;
import io.natron.noscope360.analyze.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MunicipalityService {

    private static final Logger log = LoggerFactory.getLogger(MunicipalityService.class);
    private final QuantitativeDataRepository quantitativeDataRepository;
    private final QualitativeDataRepository qualitativeDataRepository;
    private final MunicipalityRepository municipalityRepository;
    private final DimensionRepository dimensionRepository;
    private final ThemeRepository themeRepository;
    private final IndicatorRepository indicatorRepository;

    public MunicipalityService(QuantitativeDataRepository quantitativeDataRepository, QualitativeDataRepository qualitativeDataRepository,
                               MunicipalityRepository municipalityRepository, DimensionRepository dimensionRepository,
                               ThemeRepository themeRepository, IndicatorRepository indicatorRepository) {
        this.quantitativeDataRepository = quantitativeDataRepository;
        this.qualitativeDataRepository = qualitativeDataRepository;
        this.municipalityRepository = municipalityRepository;
        this.dimensionRepository = dimensionRepository;
        this.themeRepository = themeRepository;
        this.indicatorRepository = indicatorRepository;
    }

    public List<MunicipalityOverviewDto> getMunicipalities() {
        List<MunicipalityOverviewDto> municipalitiesOverviews = new ArrayList<>();
        municipalityRepository.findAll().forEach(municipality -> {
            MunicipalityDto municipalityDto = getMunicipalityById(municipality.getBfsNr());
            double avgQuantitativeRating = calcAvgRating(municipalityDto.quantitativeData().stream()
                    .flatMap(dimensionDto -> dimensionDto.themes().stream())
                    .flatMap(themeDto -> themeDto.indicators().stream())
                    .map(IndicatorDto::getRating)
                    .toList());
            double avgQualitativeRating = calcAvgRating(municipalityDto.qualitativeData().stream()
                    .flatMap(dimensionDto -> dimensionDto.themes().stream())
                    .flatMap(themeDto -> themeDto.indicators().stream())
                    .map(IndicatorDto::getRating)
                    .toList());
            MunicipalityOverviewDto municipalityOverviewDto = new MunicipalityOverviewDto(municipality.getBfsNr(),
                    municipality.getMunicipality(), municipality.getRegion(), municipality.getCanton(),
                    municipality.getDistrict(), avgQuantitativeRating, avgQualitativeRating);
            municipalitiesOverviews.add(municipalityOverviewDto);
        });
        return municipalitiesOverviews;
    }

    public MunicipalityStatsDto getMunicipalitiesStats() {
        List<MunicipalityOverviewDto> municipalities = getMunicipalities();
        int totalMunicipalities = municipalities.size();
        double avgQuantitativeRating = calcAvgRating(municipalities.stream().map(avg ->
                (int) Math.round(avg.avgQuantitativeRating())).toList());
        double avgQualitativeRating = calcAvgRating(municipalities.stream().map(avg ->
                (int) Math.round(avg.avgQualitativeRating())).toList());
        return new MunicipalityStatsDto(totalMunicipalities, avgQuantitativeRating, avgQualitativeRating);
    }

    public MunicipalityDto getMunicipalityById(int id) {
        Municipality municipality = municipalityRepository.findByBfsNr(id).orElseThrow();

        List<QuantitativeData> quantitativeDataList = quantitativeDataRepository.findByMunicipality(municipality.getMunicipality());
        List<IndicatorDto> quantiIndicatorDtoList = mapToIndicatorDtoList(quantitativeDataList, QuantitativeData::getIndicator);
        List<ThemeDto> quantiThemeDtoList = mapToThemeDtoList(quantiIndicatorDtoList);
        List<DimensionDto> quantitativeData = mapToDimensionDtoList(quantiThemeDtoList);

        List<QualitativeData> qualitativeDataList = qualitativeDataRepository.findByMunicipality(municipality.getMunicipality());
        List<IndicatorDto> qualiIndicatorDtoList = mapToIndicatorDtoList(qualitativeDataList, QualitativeData::getIndicator);
        List<ThemeDto> themeDtoList = mapToThemeDtoList(qualiIndicatorDtoList);
        List<DimensionDto> qualitativeData = mapToDimensionDtoList(themeDtoList);

        return new MunicipalityDto(municipality.getBfsNr(), municipality.getMunicipality(), municipality.getRegion(),
                municipality.getCanton(), municipality.getDistrict(), quantitativeData, qualitativeData);
    }

    private double calcAvgRating(List<Integer> ratings) {
        return ratings.stream().mapToDouble(a -> a).average().orElseThrow();
    }

    private <T extends IdentifiableValue> List<IndicatorDto> mapToIndicatorDtoList(List<T> dataList, IndicatorNameExtractor<T> extractor) {
        ScaleMappingDelegator delegator = new ScaleMappingDelegator();
        var result = dataList.stream()
                .map(data -> indicatorRepository.findByName(extractor.extract(data)).orElseThrow())
                .distinct()
                .map(indicator -> {
                    var dto = new IndicatorDto(indicator.getName(), indicator.getDescription());
                    delegator.addIndicator(dto, dataList.stream().filter(e -> e.getId().equals(indicator.getId())).findFirst().orElseThrow().getValue());
                    return dto;
                })
                .collect(Collectors.toList());
        delegator.bulkCalculateScales(result);
        return result;
    }

    private List<ThemeDto> mapToThemeDtoList(List<IndicatorDto> indicatorDtoList) {
        return indicatorDtoList.stream()
                .flatMap(indicatorDto -> themeRepository.findByName(indicatorDto.getName()).stream())
                .distinct()
                .map(theme -> new ThemeDto(theme.getName(), theme.getDescription(), indicatorDtoList))
                .collect(Collectors.toList());
    }

    private List<DimensionDto> mapToDimensionDtoList(List<ThemeDto> themeDtoList) {
        return themeDtoList.stream()
                .flatMap(themeDto -> dimensionRepository.findByName(themeDto.name()).stream())
                .distinct()
                .map(dimension -> new DimensionDto(dimension.getName(), dimension.getDescription(), themeDtoList))
                .collect(Collectors.toList());
    }
}
