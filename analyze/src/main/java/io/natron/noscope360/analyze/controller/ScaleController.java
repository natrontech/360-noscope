package io.natron.noscope360.analyze.controller;

import io.natron.noscope360.analyze.service.ScaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/scale")
public class ScaleController {

    private static final Logger log = LoggerFactory.getLogger(ScaleController.class);
    private final ScaleService scaleService;

    public ScaleController(ScaleService scaleService) {
        this.scaleService = scaleService;
    }
}
