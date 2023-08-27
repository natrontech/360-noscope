package io.natron.noscope360.analyze.model.dto;

import java.util.List;

public record SurveyAnswersDto(String id, List<AnswersDto> answers) {
}
