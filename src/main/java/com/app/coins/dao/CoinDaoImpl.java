package com.app.coins.dao;

import com.app.coins.domain.Coin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO: Add comment
 */
@Repository
public class CoinDaoImpl implements CoinDao {
    @Override
    public Long persist(Coin coin) {
        return null;
    }

    @Override
    public List<Coin> findAll() {
        return null;
    }

    @Override
    public void update(Coin coin) {

    }

    @Override
    public void delete(Coin coin) {

    }

    @Override
    public Coin find(Long id) {
        return null;
    }
}
