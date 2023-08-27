package io.natron.noscope360.analyze.service;

import io.natron.noscope360.analyze.client.SurveyClient;
import io.natron.noscope360.analyze.exception.InvalidInputException;
import io.natron.noscope360.analyze.exception.SurveyNotFoundException;
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

    private final SurveyClient surveyClient;
    private final QualitativeDataRepository qualitativeDataRepository;

    public SurveyService(SurveyClient surveyClient, QualitativeDataRepository qualitativeDataRepository) {
        this.surveyClient = surveyClient;
        this.qualitativeDataRepository = qualitativeDataRepository;
    }

    public List<SurveyOverviewDto> getSurveys() {
        return null;
    }

    public SurveyStatsDto getSurveyStats() {
        return null;
    }

    public SurveyDto getSurveyById(String id) {
        return null;
    }

    public SurveyAnswersDto makeSurveyAnswers(String id, SurveyAnswersDto surveyAnswersDto) throws SurveyNotFoundException, InvalidInputException {
        if (!surveyClient.callSurveyAPI(id)) {
            throw new SurveyNotFoundException("Survey not found: " + id);
        }
        if (!id.equals(surveyAnswersDto.id())) {
            throw new InvalidInputException("Given ID and ID in the request body are not matching.");
        }

        return null;
    }
}
