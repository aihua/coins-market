package com.app.coins.service;

import com.app.coins.dao.CoinDao;
import com.app.coins.domain.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO: Add comment
 */
@Service
public class CoinServiceImpl implements CoinService {

    @Autowired
    private CoinDao coinDao;

    @Override
    public Long save(Coin coin) {
        return coinDao.persist(coin);
    }

    @Override
    public Coin read(Long id) {
        return coinDao.find(id);
    }

    @Override
    public List<Coin> readAll() {
        return coinDao.findAll();
    }

    @Override
    public void update(Coin coin) {
        coinDao.update(coin);
    }

    @Override
    public void delete(Coin coin) {
        coinDao.delete(coin);
    }

    private BigDecimal calculatePrice(Coin coin) {
        return null;
    }
}
