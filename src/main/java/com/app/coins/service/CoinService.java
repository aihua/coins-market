package com.app.coins.service;

import com.app.coins.domain.Coin;

import java.util.List;

/**
 * TODO: Add comment
 */
public interface CoinService {

    Long save(Coin coin);

    Coin read(Long id);

    List<Coin> readAll();

    void update(Coin coin);

    void delete(Coin coin);
}
