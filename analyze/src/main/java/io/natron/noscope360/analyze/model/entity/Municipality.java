package io.natron.noscope360.analyze.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Document(indexName = "municipalities")
public class Municipality {
    @Id
    private String id;
    @Field(type = FieldType.Keyword)
    private String municipality;
    @Field(type = FieldType.Integer)
    private int histNr;
    @Field(type = FieldType.Keyword)
    private String region;
    @Field(type = FieldType.Keyword)
    private String canton;
    @Field(type = FieldType.Keyword)
    private String district;
    @Field(type = FieldType.Integer)
    private int districtNr;
    @Field(type = FieldType.Integer)
    private int bfsNr;
    @Field(type = FieldType.Date)
    private LocalDate dateOfEntry;

    public Municipality() {
    }

    public Municipality(String id, String municipality, int histNr, String region, String canton, String district,
                        int districtNr, int bfsNr, LocalDate dateOfEntry) {
        this.id = id;
        this.municipality = municipality;
        this.histNr = histNr;
        this.region = region;
        this.canton = canton;
        this.district = district;
        this.districtNr = districtNr;
        this.bfsNr = bfsNr;
        this.dateOfEntry = dateOfEntry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getHistNr() {
        return histNr;
    }

    public void setHistNr(int histNr) {
        this.histNr = histNr;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getDistrictNr() {
        return districtNr;
    }

    public void setDistrictNr(int districtNr) {
        this.districtNr = districtNr;
    }

    public int getBfsNr() {
        return bfsNr;
    }

    public void setBfsNr(int bfsNr) {
        this.bfsNr = bfsNr;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }
}
