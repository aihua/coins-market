package com.app.coins.service;

import com.app.coins.dao.GenericDao;
import com.app.coins.domain.Coin;
import com.app.coins.parsing.PriceTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO: Add comment
 */
@Service
public class CoinServiceImpl implements CoinService {

    private final static Logger Logger = LoggerFactory.getLogger(CoinServiceImpl.class);

    @Autowired
    @Qualifier("coinDao")
    private GenericDao<Coin, Long> coinDao;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private PriceTypeService priceTypeService;

    @Transactional
    public void save(Coin coin) {
        Logger.info("Saving new Coin started");
        coin.setPrice(calculatePrice(coin));
        coinDao.persist(coin);
        if (coin.getPrice() != null) {
            notificationService.notifySubscribers(coin);
        } else {
            notificationService.notifySupervisor(coin);
            Logger.warn("Coin can't be saved!");
        }
    }

    @Transactional
    public Coin read(Long id) {
        return coinDao.find(id);
    }

    @Transactional
    public List<Coin> readAll() {
        return coinDao.findAll();
    }

    @Transactional
    public void update(Coin coin) {
        coinDao.update(coin);
    }

    @Transactional
    public void delete(Coin coin) {
        coinDao.delete(coin);
    }

    private BigDecimal calculatePrice(Coin coin) {
        BigDecimal price = priceTypeService.extractPrice(coin);
        if (price == null) {
            //TODO: add logging
        }
        return price;
    }
}
