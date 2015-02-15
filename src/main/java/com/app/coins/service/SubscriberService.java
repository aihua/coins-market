package com.app.coins.service;

import com.app.coins.domain.Subscriber;

import java.util.List;

/**
 * TODO: Add comment
 */
public interface SubscriberService {

    public void save(Subscriber subscriber);

    public Subscriber read(String email);

    public List<Subscriber> readAll();

    public void update(Subscriber subscriber);

    public void delete(Subscriber subscriber);
}
