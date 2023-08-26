package io.natron.noscope360.analyze.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Document(indexName = "360noscope_data")
public class IndicatorData {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String dimension;
    @Field(type = FieldType.Text)
    private String theme;
    @Field(type = FieldType.Text)
    private String indicator;
    @Field(type = FieldType.Integer)
    private int value;
    @Field(type = FieldType.Text)
    private String canton;
    @Field(type = FieldType.Text)
    private String municipality;
    @Field(type = FieldType.Integer)
    private int plz;
    @Field(type = FieldType.Text)
    private String source;
    @Field(type = FieldType.Date)
    private LocalDateTime timestamp;

    public IndicatorData() {
    }

    public IndicatorData(String id, String dimension, String theme, String indicator, int value, String canton,
                         String municipality, int plz, String source, LocalDateTime timestamp) {
        this.id = id;
        this.dimension = dimension;
        this.theme = theme;
        this.indicator = indicator;
        this.value = value;
        this.canton = canton;
        this.municipality = municipality;
        this.plz = plz;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
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
