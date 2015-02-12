package com.app.coins.parsing;

import java.math.BigDecimal;

/**
 * TODO: Add class description
 */
public class PriceType {

    private String country;
    private String composition;
    private Integer yearFrom;
    private Integer yearTill;
    private String grade;
    private BigDecimal price;

    public PriceType() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getYearTill() {
        return yearTill;
    }

    public void setYearTill(Integer yearTill) {
        this.yearTill = yearTill;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
