package io.natron.noscope360.analyze.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "360noscope_survey_data")
public class SurveyData {
    @Id
    private String id;
}
