package io.natron.noscope360.analyze.controller;

import io.natron.noscope360.analyze.model.enums.Dimension;
import io.natron.noscope360.analyze.model.enums.Theme;
import io.natron.noscope360.analyze.model.indicator.Indicator;
import io.natron.noscope360.analyze.service.ScaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Controller that handles scale related operations.
 */
@Validated
@RestController
@RequestMapping("/scale")
public class ScaleController {

    private static final Logger log = LoggerFactory.getLogger(ScaleController.class);

    private final ScaleService scaleService;

    /**
     * Constructs a new instance of the ScaleController.
     *
     * @param scaleService The service to handle scale related operations.
     */
    public ScaleController(ScaleService scaleService) {
        this.scaleService = scaleService;
    }

    /**
     * Retrieves all available dimensions.
     *
     * @return List of available dimensions.
     */
    @Operation(summary = "Get all dimension.", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/dimensions", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Dimension> getDimensions() {
        log.info("Get all dimension.");
        return scaleService.getDimensions();
    }

    /**
     * Retrieves all themes associated with a given dimension.
     *
     * @param dimension The dimension for which themes are to be retrieved.
     * @return List of themes associated with the specified dimension.
     */
    @Operation(summary = "Get all themes of an dimension.", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/{dimension}/themes", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Theme> getThemes(@PathVariable String dimension) {
        log.info("Get all themes of an dimension.");
        return scaleService.getThemes(dimension);
    }

    /**
     * Retrieves all indicators associated with a specific theme within a given dimension.
     *
     * @param dimension The dimension within which the theme resides.
     * @param theme     The theme for which indicators are to be retrieved.
     * @return List of indicators associated with the specified theme.
     */
    @Operation(summary = "Get all indicators of a theme.", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/{dimension}/{theme}/", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Indicator> getIndicators(@PathVariable String dimension, @PathVariable String theme) {
        log.info("Get all indicators of a theme.");
        return scaleService.getIndicatorsByTheme(dimension, theme);
    }

    /**
     * Retrieves the scales of all indicators associated with a specific municipality.
     *
     * @param municipality The municipality for which the scales of the indicators are to be retrieved.
     * @return List of the scales of the indicators associated with the specified municipality.
     */
    @Operation(summary = "Get all indicators of a specific municipality.", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(path = "/indicator", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Indicator> getIndicators(@RequestParam String municipality) {
        log.info("Get all indicators of a specific municipality.");
        return scaleService.getIndicatorsByMunicipality(municipality);
    }
}
