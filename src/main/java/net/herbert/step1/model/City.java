package net.herbert.step1.model;

import com.opencsv.bean.CsvBindByName;

public class City {
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String country;
    @CsvBindByName
    private String subcountry;
    @CsvBindByName
    private Integer geonameid;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getSubcountry() {
        return subcountry;
    }
    public void setSubcountry(String subcountry) {
        this.subcountry = subcountry;
    }
    public Integer getGeonameid() {
        return geonameid;
    }
    public void setGeonameid(Integer geonameid) {
        this.geonameid = geonameid;
    }
}
