package com.app.coins.service;

import com.app.coins.domain.Subscriber;

import java.util.List;

/**
 * Service for operation with subscriber
 */
public interface SubscriberService {

    /**
     * Save new subscriber into system
     *
     * @param subscriber saving object
     */
    public void save(Subscriber subscriber);

    /**
     * Read subscriber from system
     *
     * @param email of stored subscriber
     * @return subscriber
     */
    public Subscriber read(String email);

    /**
     * Read all subscribers from system
     *
     * @return all subscribers
     */
    public List<Subscriber> readAll();

    /**
     * Update existing subscriber
     *
     * @param subscriber for update
     */
    public void update(Subscriber subscriber);

    /**
     * Delete existing subscriber
     *
     * @param subscriber for delete
     */
    public void delete(Subscriber subscriber);
}
