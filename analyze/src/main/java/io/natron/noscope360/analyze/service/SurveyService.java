package io.natron.noscope360.analyze.service;

import io.natron.noscope360.analyze.repository.SurveyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    private static final Logger log = LoggerFactory.getLogger(ScaleService.class);
    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }
}
