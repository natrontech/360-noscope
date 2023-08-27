package io.natron.noscope360.analyze.model.dto;

public record MunicipalityOverviewDto(int id, String name, String region, String canton, String district,
                                      double avgQuantitativeRating, double avgQualitativeRating) {
}
