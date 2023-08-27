package io.natron.noscope360.analyze.service;

import io.natron.noscope360.analyze.helper.IndicatorNameExtractor;
import io.natron.noscope360.analyze.helper.ScaleMappingDelegator;
import io.natron.noscope360.analyze.model.dto.*;
import io.natron.noscope360.analyze.model.entity.IdentifiableValue;
import io.natron.noscope360.analyze.model.entity.Municipality;
import io.natron.noscope360.analyze.model.entity.QualitativeData;
import io.natron.noscope360.analyze.model.entity.QuantitativeData;
import io.natron.noscope360.analyze.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class responsible for handling municipality-related operations.
 */
@Service
public class MunicipalityService {

    private static final Logger log = LoggerFactory.getLogger(MunicipalityService.class);
    private final QuantitativeDataRepository quantitativeDataRepository;
    private final QualitativeDataRepository qualitativeDataRepository;
    private final MunicipalityRepository municipalityRepository;
    private final DimensionRepository dimensionRepository;
    private final ThemeRepository themeRepository;
    private final IndicatorRepository indicatorRepository;

    /**
     * Constructs a new instance of {@link MunicipalityService}.
     *
     * @param quantitativeDataRepository Repository to access quantitative data.
     * @param qualitativeDataRepository  Repository to access qualitative data.
     * @param municipalityRepository     Repository to access municipality data.
     * @param dimensionRepository        Repository to access dimension data.
     * @param themeRepository            Repository to access theme data.
     * @param indicatorRepository        Repository to access indicator data.
     */
    public MunicipalityService(QuantitativeDataRepository quantitativeDataRepository, QualitativeDataRepository qualitativeDataRepository,
                               MunicipalityRepository municipalityRepository, DimensionRepository dimensionRepository,
                               ThemeRepository themeRepository, IndicatorRepository indicatorRepository) {
        this.quantitativeDataRepository = quantitativeDataRepository;
        this.qualitativeDataRepository = qualitativeDataRepository;
        this.municipalityRepository = municipalityRepository;
        this.dimensionRepository = dimensionRepository;
        this.themeRepository = themeRepository;
        this.indicatorRepository = indicatorRepository;

        log.info("MunicipalityService initialized.");
    }

    /**
     * Fetches an overview of all municipalities.
     *
     * @return A list of {@link MunicipalityOverviewDto} representing the overview of all municipalities.
     */
    public List<MunicipalityOverviewDto> getMunicipalities() {
        log.info("Fetching overview for all municipalities...");

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

    /**
     * Computes statistics for all municipalities.
     *
     * @return {@link MunicipalityStatsDto} representing the statistics of all municipalities.
     */
    public MunicipalityStatsDto getMunicipalitiesStats() {
        log.info("Computing statistics for all municipalities...");

        List<MunicipalityOverviewDto> municipalities = getMunicipalities();
        int totalMunicipalities = municipalities.size();
        double avgQuantitativeRating = calcAvgRating(municipalities.stream().map(avg ->
                (int) Math.round(avg.avgQuantitativeRating())).toList());
        double avgQualitativeRating = calcAvgRating(municipalities.stream().map(avg ->
                (int) Math.round(avg.avgQualitativeRating())).toList());
        return new MunicipalityStatsDto(totalMunicipalities, avgQuantitativeRating, avgQualitativeRating);
    }

    /**
     * Fetches municipality details by its ID.
     *
     * @param id The ID of the municipality.
     * @return {@link MunicipalityDto} containing details of the specified municipality.
     */
    public MunicipalityDto getMunicipalityById(int id) {
        log.info("Fetching details for municipality with ID: {}", id);

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

    /**
     * Calculates the average rating from a list of ratings.
     *
     * @param ratings A list of integer ratings.
     * @return The average rating.
     */
    private double calcAvgRating(List<Integer> ratings) {
        return ratings.stream().mapToDouble(a -> a).average().orElseThrow();
    }

    /**
     * Maps a list of data to a list of {@link IndicatorDto}.
     *
     * @param <T>       Type of data.
     * @param dataList  List of data.
     * @param extractor Function to extract indicator name from the data.
     * @return A list of {@link IndicatorDto}.
     */
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

    /**
     * Maps a list of {@link IndicatorDto} to a list of {@link ThemeDto}.
     *
     * @param indicatorDtoList List of {@link IndicatorDto}.
     * @return A list of {@link ThemeDto}.
     */
    private List<ThemeDto> mapToThemeDtoList(List<IndicatorDto> indicatorDtoList) {
        return indicatorDtoList.stream()
                .flatMap(indicatorDto -> themeRepository.findByName(indicatorDto.getName()).stream())
                .distinct()
                .map(theme -> new ThemeDto(theme.getName(), theme.getDescription(), indicatorDtoList))
                .collect(Collectors.toList());
    }

    /**
     * Maps a list of {@link ThemeDto} to a list of {@link DimensionDto}.
     *
     * @param themeDtoList List of {@link ThemeDto}.
     * @return A list of {@link DimensionDto}.
     */
    private List<DimensionDto> mapToDimensionDtoList(List<ThemeDto> themeDtoList) {
        return themeDtoList.stream()
                .flatMap(themeDto -> dimensionRepository.findByName(themeDto.name()).stream())
                .distinct()
                .map(dimension -> new DimensionDto(dimension.getName(), dimension.getDescription(), themeDtoList))
                .collect(Collectors.toList());
    }
}
