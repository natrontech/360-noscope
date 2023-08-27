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

/**
 * Service responsible for managing and processing survey data.
 */
@Service
public class SurveyService {

    private static final Logger log = LoggerFactory.getLogger(SurveyService.class);

    private final SurveyClient surveyClient;
    private final QualitativeDataRepository qualitativeDataRepository;

    /**
     * Constructor to initialize the SurveyService with the required dependencies.
     *
     * @param surveyClient              client to interact with survey API.
     * @param qualitativeDataRepository repository to fetch qualitative data.
     */
    public SurveyService(SurveyClient surveyClient, QualitativeDataRepository qualitativeDataRepository) {
        this.surveyClient = surveyClient;
        this.qualitativeDataRepository = qualitativeDataRepository;

        log.info("SurveyService initialized.");
    }

    /**
     * Fetches an overview of all available surveys.
     *
     * @return a list of SurveyOverviewDto representing all surveys.
     */
    public List<SurveyOverviewDto> getSurveys() {
        log.info("Fetching overview for all surveys...");
        // TODO: Implement the logic to get the surveys overview. Not implemented due to time constraints.
        return null;
    }

    /**
     * Provides statistics related to surveys.
     *
     * @return a SurveyStatsDto containing survey statistics.
     */
    public SurveyStatsDto getSurveyStats() {
        log.info("Computing statistics over all surveys...");
        // TODO: Implement the logic to get the survey stats. Not implemented due to time constraints.
        return null;
    }

    /**
     * Fetches a specific survey by its ID.
     *
     * @param id the unique identifier of the survey.
     * @return a SurveyDto representing the requested survey.
     */
    public SurveyDto getSurveyById(String id) {
        log.info("Fetching details for survey with ID: {}", id);
        // TODO: Implement the logic to get a details of a survey by ID. Not implemented due to time constraints.
        return null;
    }

    /**
     * Generates answers for a survey.
     *
     * @param id               the unique identifier of the survey.
     * @param surveyAnswersDto the DTO containing the survey answers data.
     * @return a SurveyAnswersDto containing the processed survey answers.
     * @throws SurveyNotFoundException if the survey is not found.
     * @throws InvalidInputException   if the provided ID and ID in the request body are not matching.
     */
    public SurveyAnswersDto makeSurveyAnswers(String id, SurveyAnswersDto surveyAnswersDto) throws SurveyNotFoundException, InvalidInputException {
        log.info("Adding answers for survey with ID: {}", id);

        if (!surveyClient.callSurveyAPI(id)) {
            throw new SurveyNotFoundException("Survey not found: " + id);
        }
        if (!id.equals(surveyAnswersDto.id())) {
            throw new InvalidInputException("Given ID and ID in the request body are not matching.");
        }

        // TODO: Implement the logic to add answers for a survey. Not implemented due to time constraints.
        return null;
    }
}
