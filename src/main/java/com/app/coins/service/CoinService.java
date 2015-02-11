package com.app.coins.service;

import com.app.coins.dao.GenericDao;
import com.app.coins.domain.Coin;
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

    @Autowired
    @Qualifier("coinDao")
    private GenericDao<Coin, Long> coinDao;

    @Autowired
    private NotificationService notificationService;

    public void save(Coin coin) {
        Long persistedId = coinDao.persist(coin);
        Coin persistedCoin = coinDao.find(persistedId);
        notificationService.notifySubscribers(persistedCoin);
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
        return null;
    }
}
