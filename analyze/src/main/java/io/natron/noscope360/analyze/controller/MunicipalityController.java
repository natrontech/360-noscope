package io.natron.noscope360.analyze.controller;

import io.natron.noscope360.analyze.model.dto.MunicipalityDto;
import io.natron.noscope360.analyze.model.dto.MunicipalityOverviewDto;
import io.natron.noscope360.analyze.model.dto.MunicipalityStatsDto;
import io.natron.noscope360.analyze.service.MunicipalityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/municipalities")
public class MunicipalityController {

    private static final Logger log = LoggerFactory.getLogger(MunicipalityController.class);
    private final MunicipalityService municipalityService;

    public MunicipalityController(MunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    @Operation(summary = "Retrieve overview data of all municipalities.", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<MunicipalityOverviewDto> getMunicipalities() {
        log.info("Retrieve overview data of all municipalities.");
        return municipalityService.getMunicipalities();
    }

    @Operation(summary = "Retrieve stats of all municipalities.", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/stats", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public MunicipalityStatsDto getMunicipalitiesStats() {
        log.info("Retrieve stats of all municipalities.");
        return municipalityService.getMunicipalitiesStats();
    }

    @Operation(summary = "Retrieve data of a specific municipality.", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public MunicipalityDto getMunicipalityById(@PathVariable String id) {
        log.info("Retrieve data of a specific municipality.");
        return municipalityService.getMunicipalityById();
    }
}
