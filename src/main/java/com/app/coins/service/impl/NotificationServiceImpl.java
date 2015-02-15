package com.app.coins.service.impl;

import com.app.coins.domain.Coin;
import com.app.coins.domain.Country;
import com.app.coins.domain.Subscriber;
import com.app.coins.service.MailService;
import com.app.coins.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Implementation of service for sending notification to recipients
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private final static Logger Logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    private static final String EMAIL_TITLE = "New coins!";
    private static final String EMAIL_TEXT = "New coin is coming: ";

    private static final String SUPERVISOR_EMAIL_TITLE = "Something going wrong!";
    private static final String SUPERVISOR_EMAIL_TEXT = "Set price for that coin: ";

    private String adminAddress;
    private String supervisorAddress;

    @Autowired
    private MailService mailService;

    @Override
    public void notifySubscribers(Coin coin) {
        Logger.info("Starting notify subscribers");
        Country country = coin.getCountry();
        if (country.getSubscribers().size() > 0) {
            String[] subscribers = extractSubscribesEmail(country.getSubscribers());
            mailService.sendMail(adminAddress, subscribers, EMAIL_TITLE, EMAIL_TEXT + coin.getDescription() + " with price: " + coin.getPrice());
        }
    }

    @Override
    public void notifySupervisor(Coin coin) {
        Logger.info("Starting notify supervisor");
        mailService.sendMail(adminAddress, supervisorAddress, SUPERVISOR_EMAIL_TITLE, SUPERVISOR_EMAIL_TEXT + coin.getDescription());
    }

    private String[] extractSubscribesEmail(Set<Subscriber> subscribers) {
        List<String> emails = new ArrayList<String>();
        for (Subscriber subscriber : subscribers) {
            emails.add(subscriber.getEmail());
        }
        return emails.toArray(new String[emails.size()]);
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public void setSupervisorAddress(String supervisorAddress) {
        this.supervisorAddress = supervisorAddress;
    }
}
