package com.app.coins.service;

import com.app.coins.domain.Country;

import java.util.List;

/**
 * TODO: Add comment
 */
public interface CountryService {

    public void save(Country country);

    public Country read(String name);

    public List<Country> readAll();

    public void update(Country country);

    public void delete(Country country);
}
