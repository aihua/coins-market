package com.app.coins.service;

import com.app.coins.dao.GenericDao;
import com.app.coins.domain.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of service for operation with subscriber
 */
@Service
public class SubscriberServiceImpl implements SubscriberService {

    private final static Logger Logger = LoggerFactory.getLogger(SubscriberServiceImpl.class);

    @Autowired
    @Qualifier("subscriberDao")
    private GenericDao<Subscriber, String> subscriberDao;

    @Transactional
    public void save(Subscriber subscriber) {
        Logger.info("Starting saving subscriber");
        String persistedEmail = subscriberDao.persist(subscriber);
        Logger.info("Subscriber " + persistedEmail + " saved");
    }

    @Transactional
    public Subscriber read(String email) {
        return subscriberDao.find(email);
    }

    @Transactional
    public List<Subscriber> readAll() {
        return subscriberDao.findAll();
    }

    @Transactional
    public void update(Subscriber subscriber) {
        subscriberDao.update(subscriber);
    }

    @Transactional
    public void delete(Subscriber subscriber) {
        subscriberDao.delete(subscriber);
    }
}
