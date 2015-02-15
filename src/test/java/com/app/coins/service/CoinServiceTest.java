package com.app.coins.service;

import com.app.coins.domain.Coin;
import com.app.coins.domain.Country;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class CoinServiceTest {

    @Autowired
    private CoinService coinService;

    @Autowired
    private CountryService countryService;

    @Test
    @Ignore
    public void testSave() throws Exception {
        Coin coin = new Coin();
        Country country = countryService.read("UK");
        coin.setCountry(country);
        coin.setCirculation(15000L);
        coin.setComposition(Coin.Composition.GOLD);
        coin.setDescription("Gold pound Coin 1344");
        coin.setGrade(Coin.Grade.GOOD);
        coin.setYear(1344);

        coinService.save(coin);
    }

    @Test
    public void testRead() throws Exception {

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