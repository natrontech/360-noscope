package io.natron.noscope360.analyze.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "qualitative-data")
public class QualitativeData {
    @Id
    private String id;
    @Field(type = FieldType.Keyword)
    private String dimension;
    @Field(type = FieldType.Keyword)
    private String theme;
    @Field(type = FieldType.Keyword)
    private String indicator;
    @Field(type = FieldType.Integer)
    private int value;
    @Field(type = FieldType.Keyword)
    private String question;
    @Field(type = FieldType.Keyword)
    private String survey;
}
