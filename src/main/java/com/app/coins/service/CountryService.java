package com.app.coins.service;

import com.app.coins.domain.Country;

import java.util.List;

/**
 * Service for operation with country
 */
public interface CountryService {

    /**
     * Save new country into system
     *
     * @param country saving object
     */
    public void save(Country country);

    /**
     * Read country from system
     *
     * @param name of stored country
     * @return country
     */
    public Country read(String name);

    /**
     * Read all countries from system
     *
     * @return all countries
     */
    public List<Country> readAll();

    /**
     * Update existing country
     *
     * @param country for update
     */
    public void update(Country country);

    /**
     * Delete existing country
     *
     * @param country for delete
     */
    public void delete(Country country);
}
