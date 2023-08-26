package io.natron.noscope360.analyze.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Document(indexName = "quantitative-data")
public class QuantitativeData {
    @Id
    private String id;
    @Field(type = FieldType.Keyword)
    private String dimension;
    @Field(type = FieldType.Keyword)
    private String theme;
    @Field(type = FieldType.Keyword)
    private String indicator;
    @Field(type = FieldType.Double)
    private double value;
    @Field(type = FieldType.Keyword)
    private String municipality;
    @Field(type = FieldType.Text)
    private String source;
    @Field(name = "@timestamp", type = FieldType.Date)
    private LocalDateTime timestamp;
}
