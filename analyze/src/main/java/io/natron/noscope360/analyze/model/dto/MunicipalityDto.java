package io.natron.noscope360.analyze.model.dto;

import java.util.List;

public record MunicipalityDto(int id, String name, String region, String canton, String district,
                              List<DimensionDto> quantitativeData, List<DimensionDto> qualitativeData) {
}
