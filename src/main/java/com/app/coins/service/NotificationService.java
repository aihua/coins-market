package com.app.coins.service;

import com.app.coins.domain.Coin;

/**
 * TODO: Add comment
 */
public interface NotificationService {

    void notifySubscribers(Coin coin);
}
