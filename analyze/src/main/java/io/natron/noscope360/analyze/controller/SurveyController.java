package io.natron.noscope360.analyze.controller;

import io.natron.noscope360.analyze.exception.InvalidInputException;
import io.natron.noscope360.analyze.exception.SurveyNotFoundException;
import io.natron.noscope360.analyze.model.dto.SurveyAnswersDto;
import io.natron.noscope360.analyze.model.dto.SurveyDto;
import io.natron.noscope360.analyze.model.dto.SurveyOverviewDto;
import io.natron.noscope360.analyze.model.dto.SurveyStatsDto;
import io.natron.noscope360.analyze.service.SurveyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * A controller to handle API requests related to surveys.
 */
@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    private static final Logger log = LoggerFactory.getLogger(SurveyController.class);

    private final SurveyService surveyService;

    /**
     * Constructor for {@link SurveyController}.
     *
     * @param surveyService the service responsible for managing surveys.
     */
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    /**
     * Get an overview of all surveys.
     *
     * @return a list of {@link SurveyOverviewDto} containing overview data for each survey.
     */
    @Operation(summary = "Retrieve overview data of all surveys.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of surveys."),
                    @ApiResponse(responseCode = "500", description = "An unexpected error occurred.")
            },
            security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SurveyOverviewDto> getSurveys() {
        log.info("Retrieve overview data of all surveys.");
        return surveyService.getSurveys();
    }

    /**
     * Get statistics for all surveys.
     *
     * @return {@link SurveyStatsDto} containing aggregated statistics for all surveys.
     */
    @Operation(summary = "Retrieve stats of all surveys.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved survey statistics."),
                    @ApiResponse(responseCode = "500", description = "An unexpected error occurred.")
            },
            security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/stats", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public SurveyStatsDto getSurveyStats() {
        log.info("Retrieve stats of all surveys.");
        return surveyService.getSurveyStats();
    }

    /**
     * Retrieve details of a specific survey identified by its ID.
     *
     * @param id the ID of the survey to fetch.
     * @return {@link SurveyDto} with detailed data of the specified survey.
     */
    @Operation(summary = "Retrieve data of a specific survey.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved survey data."),
                    @ApiResponse(responseCode = "404", description = "Survey not found."),
                    @ApiResponse(responseCode = "500", description = "An unexpected error occurred.")
            },
            security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public SurveyDto getSurveyById(@PathVariable String id) {
        log.info("Retrieve data of a specific survey with ID: {}", id);
        return surveyService.getSurveyById(id);
    }

    /**
     * Provide answers for a specific survey identified by its ID.
     *
     * @param id               the ID of the survey for which answers are being provided.
     * @param surveyAnswersDto DTO containing the provided answers.
     * @return {@link SurveyAnswersDto} containing the saved answers.
     */
    @Operation(summary = "Provide answers for a survey.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successfully created survey answers."),
                    @ApiResponse(responseCode = "400", description = "Invalid input."),
                    @ApiResponse(responseCode = "404", description = "Survey not found."),
                    @ApiResponse(responseCode = "500", description = "An unexpected error occurred.")
            })
    @PostMapping(path = "/{id}/answers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SurveyAnswersDto makeSurveyAnswers(@PathVariable String id, @RequestBody SurveyAnswersDto surveyAnswersDto) throws SurveyNotFoundException, InvalidInputException {
        log.info("Providing answers for survey with ID: {}", id);
        return surveyService.makeSurveyAnswers(id, surveyAnswersDto);
    }
}
