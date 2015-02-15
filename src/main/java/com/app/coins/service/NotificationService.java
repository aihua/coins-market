package com.app.coins.service;

import com.app.coins.domain.Coin;

/**
 * Service for sending notification to recipients
 */
public interface NotificationService {

    /**
     * Notify all coin subscribers by email
     *
     * @param coin new coin in system
     */
    void notifySubscribers(Coin coin);

    /**
     * Notify supervisor by email
     *
     * @param coin new coin in system
     */
    void notifySupervisor(Coin coin);
}
