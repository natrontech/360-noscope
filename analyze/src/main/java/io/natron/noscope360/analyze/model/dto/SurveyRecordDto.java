package io.natron.noscope360.analyze.model.dto;

import java.util.List;

public record SurveyRecordDto(String id, String collectionId, String collectionName, String created, String updated,
                              String name, List<String> survey_questions) {
}
