package com.app.coins.service;

import com.app.coins.domain.Coin;

import java.util.List;

/**
 * TODO: Add comment
 */
public interface CoinService {

    public void save(Coin coin);

    public Coin read(Long id);

    public List<Coin> readAll();

    public void update(Coin coin);

    public void delete(Coin coin);
}
