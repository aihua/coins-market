package com.app.coins.service;

import com.app.coins.dao.GenericDao;
import com.app.coins.domain.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of service for operation with country
 */
@Service
public class CountryServiceImpl implements CountryService {

    private final static Logger Logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    @Qualifier("countryDao")
    private GenericDao<Country, String> countryDao;

    @Transactional
    public void save(Country country) {
        Logger.info("Starting country persisting");
        String persistedName = countryDao.persist(country);
        Logger.info("Country persists: " + persistedName);
    }

    @Transactional
    public Country read(String name) {
        Logger.info("Reading country");
        return countryDao.find(name);
    }

    @Transactional
    public List<Country> readAll() {
        return countryDao.findAll();
    }

    @Transactional
    public void update(Country country) {
        countryDao.update(country);
    }

    @Transactional
    public void delete(Country country) {
        countryDao.delete(country);
    }
}
