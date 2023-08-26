package io.natron.noscope360.analyze.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "indicators")
public class Indicator {
    @Id
    private String id;
    @Field(name = "indicator_name", type = FieldType.Keyword)
    private String name;
    @Field(type = FieldType.Text)
    private String description;
    @Field(name = "associated_theme", type = FieldType.Keyword)
    private String theme;

    public Indicator() {
    }

    public Indicator(String id, String name, String description, String theme) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.theme = theme;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
