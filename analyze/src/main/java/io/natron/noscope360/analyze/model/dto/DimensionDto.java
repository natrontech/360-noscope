package io.natron.noscope360.analyze.model.dto;

import java.util.List;

public record DimensionDto(String name, String description, List<ThemeDto> themes) {
}
