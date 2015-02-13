package com.app.coins.service;

import com.app.coins.dao.GenericDao;
import com.app.coins.domain.Coin;
import com.app.coins.parsing.PriceTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO: Add comment
 */
@Service
public class CoinService {

    private final static Logger Logger = LoggerFactory.getLogger(CoinService.class);

    @Autowired
    @Qualifier("coinDao")
    private GenericDao<Coin, Long> coinDao;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private PriceTypeService priceTypeService;

    public void save(Coin coin) {
        Logger.info("Saving new Coin started");
        coin.setPrice(calculatePrice(coin));
        Long persistedId = coinDao.persist(coin);
        if (persistedId != null) {
            Coin persistedCoin = coinDao.find(persistedId);
            notificationService.notifySubscribers(persistedCoin);
        } else {
            Logger.warn("Coin can't be saved!");
        }
    }

    public Coin read(Long id) {
        return coinDao.find(id);
    }

    public List<Coin> readAll() {
        return coinDao.findAll();
    }

    public void update(Coin coin) {
        coinDao.update(coin);
    }

    public void delete(Coin coin) {
        coinDao.delete(coin);
    }

    private BigDecimal calculatePrice(Coin coin) {
        BigDecimal price = priceTypeService.extractPrice(coin);
        if (price == null) {
            //TODO: add logging
            notificationService.notifySupervisor(coin);
        }
        return price;
    }
}
