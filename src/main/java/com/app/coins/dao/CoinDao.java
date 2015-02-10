package com.app.coins.dao;

import com.app.coins.domain.Coin;

import java.util.List;

/**
 * TODO: Add comment
 */
public interface CoinDao {

    Long persist(Coin coin);

    Coin find(Long id);

    List<Coin> findAll();

    void update(Coin coin);

    void delete(Coin coin);
}
