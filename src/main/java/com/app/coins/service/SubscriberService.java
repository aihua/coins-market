package com.app.coins.service;

import com.app.coins.dao.GenericDao;
import com.app.coins.domain.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: Add comment
 */
@Service
public class SubscriberService {

    @Autowired
    @Qualifier("subscriberDao")
    private GenericDao<Subscriber, String> subscriberDao;

    public void save(Subscriber subscriber) {
        String persistedEmail = subscriberDao.persist(subscriber);
    }

    public Subscriber read(String email) {
        return subscriberDao.find(email);
    }

    public List<Subscriber> readAll() {
        return subscriberDao.findAll();
    }

    public void update(Subscriber subscriber) {
        subscriberDao.update(subscriber);
    }

    public void delete(Subscriber subscriber) {
        subscriberDao.delete(subscriber);
    }
}
