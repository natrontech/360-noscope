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

    public QuantitativeData() {
    }

    public QuantitativeData(String id, String dimension, String theme, String indicator, double value,
                            String municipality, String source, LocalDateTime timestamp) {
        this.id = id;
        this.dimension = dimension;
        this.theme = theme;
        this.indicator = indicator;
        this.value = value;
        this.municipality = municipality;
        this.source = source;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
