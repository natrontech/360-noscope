package io.natron.noscope360.analyze.controller;

import io.natron.noscope360.analyze.model.dto.MunicipalityDto;
import io.natron.noscope360.analyze.model.dto.MunicipalityOverviewDto;
import io.natron.noscope360.analyze.model.dto.MunicipalityStatsDto;
import io.natron.noscope360.analyze.service.MunicipalityService;
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
 * Controller to handle API requests related to municipalities.
 */
@RestController
@RequestMapping("/api/municipalities")
public class MunicipalityController {

    private static final Logger log = LoggerFactory.getLogger(MunicipalityController.class);

    private final MunicipalityService municipalityService;

    /**
     * Constructor for {@link MunicipalityController}.
     *
     * @param municipalityService the service to interact with municipality data.
     */
    public MunicipalityController(MunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    /**
     * Get an overview of all municipalities.
     *
     * @return a list of {@link MunicipalityOverviewDto} representing all municipalities.
     */
    @Operation(summary = "Retrieve overview data of all municipalities.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of municipalities."),
                    @ApiResponse(responseCode = "500", description = "An unexpected error occurred.")
            },
            security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<MunicipalityOverviewDto> getMunicipalities() {
        log.info("Retrieve overview data of all municipalities.");
        return municipalityService.getMunicipalities();
    }

    /**
     * Get statistics of all municipalities.
     *
     * @return {@link MunicipalityStatsDto} containing statistics of all municipalities.
     */
    @Operation(summary = "Retrieve stats of all municipalities.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved stats of municipalities."),
                    @ApiResponse(responseCode = "500", description = "An unexpected error occurred.")
            },
            security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/stats", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public MunicipalityStatsDto getMunicipalitiesStats() {
        log.info("Retrieve stats of all municipalities.");
        return municipalityService.getMunicipalitiesStats();
    }

    /**
     * Get details of a specific municipality by its ID.
     *
     * @param id the ID of the municipality to fetch.
     * @return {@link MunicipalityDto} with the details of the specified municipality.
     */
    @Operation(summary = "Retrieve data of a specific municipality.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved municipality data."),
                    @ApiResponse(responseCode = "404", description = "Municipality not found."),
                    @ApiResponse(responseCode = "500", description = "An unexpected error occurred.")
            },
            security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public MunicipalityDto getMunicipalityById(@PathVariable String id) {
        log.info("Retrieve data of a specific municipality with ID: {}", id);
        return municipalityService.getMunicipalityById(id);
    }
}
