package io.natron.noscope360.analyze.controller;

import io.natron.noscope360.analyze.model.dto.SurveyAnswersDto;
import io.natron.noscope360.analyze.model.dto.SurveyDto;
import io.natron.noscope360.analyze.model.dto.SurveyOverviewDto;
import io.natron.noscope360.analyze.model.dto.SurveyStatsDto;
import io.natron.noscope360.analyze.service.SurveyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    private static final Logger log = LoggerFactory.getLogger(SurveyController.class);
    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @Operation(summary = "Retrieve overview data of all surveys.", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SurveyOverviewDto> getSurveys() {
        log.info("Retrieve overview data of all surveys.");
        return surveyService.getSurveys();
    }

    @Operation(summary = "Retrieve stats of all surveys.", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/stats", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public SurveyStatsDto getSurveyStats() {
        log.info("Retrieve stats of all surveys.");
        return surveyService.getSurveyStats();
    }

    @Operation(summary = "Retrieve data of a specific surveys.", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public SurveyDto getSurveyById(@PathVariable String id) {
        log.info("Retrieve data of a specific surveys.");
        return surveyService.getSurveyById();
    }

    @Operation(summary = "Make a answers for a survey.")
    @PostMapping(path = "/{id}/answers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SurveyAnswersDto makeSurveyAnswers(@PathVariable String id, @Valid @RequestBody SurveyAnswersDto surveyAnswersDto) {
        log.info("Make a survey answers for a survey.");
        return surveyService.makeSurveyAnswers(id, surveyAnswersDto);
    }
}
