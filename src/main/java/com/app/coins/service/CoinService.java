package com.app.coins.service;

import com.app.coins.domain.Coin;

import java.util.List;

/**
 * Service for operation with coin
 */
public interface CoinService {

    /**
     * Save new coin into system
     *
     * @param coin saving object
     */
    public void save(Coin coin);

    /**
     * Read coin from system
     *
     * @param id of stored coin
     * @return coin
     */
    public Coin read(Long id);

    /**
     * Read all coins from system
     *
     * @return all coins
     */
    public List<Coin> readAll();

    /**
     * Update existing coin
     *
     * @param coin for update
     */
    public void update(Coin coin);

    /**
     * Delete existing coin
     *
     * @param coin for delete
     */
    public void delete(Coin coin);
}
