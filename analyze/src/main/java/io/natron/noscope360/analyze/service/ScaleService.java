package io.natron.noscope360.analyze.service;

import io.natron.noscope360.analyze.repository.IndicatorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ScaleService {

    private static final Logger log = LoggerFactory.getLogger(ScaleService.class);
    private final IndicatorRepository indicatorRepository;

    public ScaleService(IndicatorRepository indicatorRepository) {
        this.indicatorRepository = indicatorRepository;
    }
}
