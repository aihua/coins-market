package com.app.coins.parsing;

import com.app.coins.domain.Coin;
import com.app.coins.domain.Country;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class PriceTypeServiceTest {

    @Autowired
    private PriceTypeService priceTypeService;

    @Test
    public void testExtractPriceRu() throws Exception {
        Coin coin = new Coin();
        Country country = new Country();
        country.setName("RU");
        coin.setCountry(country);
        coin.setCirculation(15000L);
        coin.setComposition(Coin.Composition.OTHER);
        coin.setDescription("Other rubl Coin 1728");
        coin.setGrade(Coin.Grade.VERYFINE);
        coin.setYear(1728);

        BigDecimal price = priceTypeService.extractPrice(coin);
        Assert.assertEquals(BigDecimal.valueOf(2500), price);
    }

    @Test
    public void testExtractPriceUk() throws Exception {
        Coin coin = new Coin();
        Country country = new Country();
        country.setName("UK");
        coin.setCountry(country);
        coin.setCirculation(15000L);
        coin.setComposition(Coin.Composition.GOLD);
        coin.setDescription("Gold pound Coin 1344");
        coin.setGrade(Coin.Grade.VERYFINE);
        coin.setYear(1344);

        BigDecimal price = priceTypeService.extractPrice(coin);
        Assert.assertEquals(BigDecimal.valueOf(82500000, 2), price);
    }
}