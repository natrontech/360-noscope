package io.natron.noscope360.analyze.service;

import io.natron.noscope360.analyze.model.dto.MunicipalityDto;
import io.natron.noscope360.analyze.model.dto.MunicipalityOverviewDto;
import io.natron.noscope360.analyze.model.dto.MunicipalityStatsDto;
import io.natron.noscope360.analyze.repository.QuantitativeDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityService {

    private static final Logger log = LoggerFactory.getLogger(MunicipalityService.class);
    private final QuantitativeDataRepository quantitativeDataRepository;

    public MunicipalityService(QuantitativeDataRepository quantitativeDataRepository) {
        this.quantitativeDataRepository = quantitativeDataRepository;
    }

    public List<MunicipalityOverviewDto> getMunicipalities() {
        return null;
    }

    public MunicipalityStatsDto getMunicipalitiesStats() {
        return null;
    }

    public MunicipalityDto getMunicipalityById(String id) {
        return null;
    }
}
