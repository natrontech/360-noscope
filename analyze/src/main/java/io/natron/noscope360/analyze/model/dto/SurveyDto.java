package io.natron.noscope360.analyze.model.dto;

import java.util.List;

public record SurveyDto(int id, String name, List<QuestionDto> questions, List<DimensionDto> qualitativeData,
                        List<MunicipalityOverviewDto> participatingMunicipalities) {
}
