package com.app.coins.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TODO: Add comment
 */
@Entity
@Table(name = "coin")
public class Coin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "composition", nullable = false)
    @Enumerated(EnumType.STRING)
    private Composition composition;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_name", nullable = false)
    private Country country;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "circulation", nullable = false)
    private Long circulation;

    @Column(name = "grade", nullable = false)
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column(name = "price")
    private BigDecimal price;

    public Coin() {
    }

    public enum Grade {
        ANY(1.0), GOOD(1.1), VERYGOOD(1.2), FINE(1.5), VERYFINE(1.65), EXTRAFINE(2.5);

        Double priceMultiplier;

        Grade(Double priceMultiplier) {
            this.priceMultiplier = priceMultiplier;
        }

        public Double getPriceMultiplier() {
            return priceMultiplier;
        }
    }

    public enum Composition {
        SILVER, GOLD, COPPER, OTHER
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getCirculation() {
        return circulation;
    }

    public void setCirculation(Long circulation) {
        this.circulation = circulation;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}