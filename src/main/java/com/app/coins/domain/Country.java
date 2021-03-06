package com.app.coins.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * TODO: Add comment
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {

    @Id
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "countries", cascade = CascadeType.ALL)
    private Set<Subscriber> subscribers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private Set<Coin> coins;

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public Set<Coin> getCoins() {
        return coins;
    }

    public void setCoins(Set<Coin> coins) {
        this.coins = coins;
    }
}
