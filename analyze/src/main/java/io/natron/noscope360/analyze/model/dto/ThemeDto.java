package io.natron.noscope360.analyze.model.dto;

import java.util.List;

public record ThemeDto(String name, String description, List<IndicatorDto> indicators) {
}
