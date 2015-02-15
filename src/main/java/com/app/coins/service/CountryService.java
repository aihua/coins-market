package com.app.coins.service;

import com.app.coins.dao.GenericDao;
import com.app.coins.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: Add comment
 */
@Service
public class CountryService {

    @Autowired
    @Qualifier("countryDao")
    private GenericDao<Country, String> countryDao;

    public void save(Country country) {
        String persistedName = countryDao.persist(country);
    }

    public Country read(String name) {
        return countryDao.find(name);
    }

    public List<Country> readAll() {
        return countryDao.findAll();
    }

    public void update(Country country) {
        countryDao.update(country);
    }

    public void delete(Country country) {
        countryDao.delete(country);
    }
}
