package com.app.coins.service;

import com.app.coins.domain.Coin;
import com.app.coins.domain.Country;
import com.app.coins.domain.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * TODO: Add comment
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private static final String FROM_ADDRESS = "myemail@email.com";
    private static final String EMAIL_TITLE = "New coins!";
    private static final String EMAIL_TEXT = "New coin is coming: ";

    private static final String SUPERVISOR_ADDRESS = "supervisor@user.com";
    private static final String SUPERVISOR_EMAIL_TITLE = "Something going wrong!";
    private static final String SUPERVISOR_EMAIL_TEXT = "Do something with that coin: ";

    @Autowired
    private MailService mailService;

    @Override
    public void notifySubscribers(Coin coin) {
        Country country = coin.getCountry();
        if (country.getSubscribers().size() > 0) {
            String[] subscribers = extractSubscribesEmail(country.getSubscribers());
            mailService.sendMail(FROM_ADDRESS, subscribers, EMAIL_TITLE, EMAIL_TEXT + coin.getDescription() + " with price: " + coin.getPrice());
        }
    }

    @Override
    public void notifySupervisor(Coin coin) {
        mailService.sendMail(FROM_ADDRESS, SUPERVISOR_ADDRESS, SUPERVISOR_EMAIL_TITLE, SUPERVISOR_EMAIL_TEXT + coin.getDescription());
    }

    private String[] extractSubscribesEmail(Set<Subscriber> subscribers) {
        List<String> emails = new ArrayList<String>();
        for (Subscriber subscriber : subscribers) {
            emails.add(subscriber.getEmail());
        }
        return emails.toArray(new String[emails.size()]);
    }
}
