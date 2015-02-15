package com.app.coins.service;

import com.app.coins.domain.Country;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
@Transactional
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    @Ignore
    public void testSave() throws Exception {
        Country country = new Country();
        country.setName("UK");
        country.setFullName("United Kingdoms");

        countryService.save(country);
    }

    @Test
    @Ignore
    public void testRead() throws Exception {
        Country country = countryService.read("UK");
        Assert.assertEquals("UK", country.getName());
        Assert.assertEquals("United Kingdoms", country.getFullName());
    }

    @Test
    public void testReadAll() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}