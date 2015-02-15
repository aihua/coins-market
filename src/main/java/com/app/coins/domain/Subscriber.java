package com.app.coins.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * TODO: Add comment
 */
@Entity
@Table(name = "subscriber")
public class Subscriber implements Serializable {

    @Id
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "subscriber_country",
            joinColumns = { @JoinColumn(name = "subscriber_email", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "country_name", nullable = false, updatable = false) })
    private Set<Country> countries;

    public Subscriber() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
