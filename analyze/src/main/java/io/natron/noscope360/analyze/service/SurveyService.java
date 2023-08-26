package io.natron.noscope360.analyze.service;

import io.natron.noscope360.analyze.model.dto.Survey;
import io.natron.noscope360.analyze.model.dto.SurveyAnswers;
import io.natron.noscope360.analyze.model.dto.SurveyOverview;
import io.natron.noscope360.analyze.model.dto.SurveyStats;
import io.natron.noscope360.analyze.repository.QualitativeDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    private static final Logger log = LoggerFactory.getLogger(SurveyService.class);
    private final QualitativeDataRepository qualitativeDataRepository;

    public SurveyService(QualitativeDataRepository qualitativeDataRepository) {
        this.qualitativeDataRepository = qualitativeDataRepository;
    }

    public List<SurveyOverview> getSurveys() {
        return null;
    }

    public SurveyStats getSurveyStats() {
        return null;
    }

    public Survey getSurveyById() {
        return null;
    }

    public SurveyAnswers makeSurveyAnswers(String id, SurveyAnswers surveyAnswers) {
        return null;
    }
}
