package net.herbert.step1.model;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name) &&
                Objects.equals(country, city.country) &&
                Objects.equals(subcountry, city.subcountry) &&
                Objects.equals(geonameid, city.geonameid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, subcountry, geonameid);
    }
}
