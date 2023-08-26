package io.natron.noscope360.analyze.service;

import io.natron.noscope360.analyze.model.dto.Municipality;
import io.natron.noscope360.analyze.model.dto.MunicipalityOverview;
import io.natron.noscope360.analyze.model.dto.MunicipalityStats;
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

    public List<MunicipalityOverview> getMunicipalities() {
        return null;
    }

    public MunicipalityStats getMunicipalitiesStats() {
        return null;
    }

    public Municipality getMunicipalityById() {
        return null;
    }
}
