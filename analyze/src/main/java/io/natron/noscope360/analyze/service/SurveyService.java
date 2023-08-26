package io.natron.noscope360.analyze.service;

import io.natron.noscope360.analyze.model.dto.SurveyAnswersDto;
import io.natron.noscope360.analyze.model.dto.SurveyDto;
import io.natron.noscope360.analyze.model.dto.SurveyOverviewDto;
import io.natron.noscope360.analyze.model.dto.SurveyStatsDto;
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

    public List<SurveyOverviewDto> getSurveys() {
        return null;
    }

    public SurveyStatsDto getSurveyStats() {
        return null;
    }

    public SurveyDto getSurveyById() {
        return null;
    }

    public SurveyAnswersDto makeSurveyAnswers(String id, SurveyAnswersDto surveyAnswersDto) {
        return null;
    }
}
