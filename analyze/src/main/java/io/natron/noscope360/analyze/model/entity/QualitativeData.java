package io.natron.noscope360.analyze.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "qualitative-data")
public class QualitativeData implements IdentifiableValue {
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
    private String question;
    @Field(type = FieldType.Keyword)
    private String survey;
    @Field(type = FieldType.Keyword)
    private String municipality;

    public QualitativeData() {
    }

    public QualitativeData(String id, String dimension, String theme, String indicator, int value, String question, String survey, String municipality) {
        this.id = id;
        this.dimension = dimension;
        this.theme = theme;
        this.indicator = indicator;
        this.value = value;
        this.question = question;
        this.survey = survey;
        this.municipality = municipality;
    }

    @Override
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

    @Override
    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
}
