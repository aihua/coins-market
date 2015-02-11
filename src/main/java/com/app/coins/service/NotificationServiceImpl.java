package com.app.coins.service;

import com.app.coins.domain.Coin;
import com.app.coins.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO: Add comment
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private static final String FROM_ADDRESS = "myemail@email.com";
    private static final String EMAIL_TITLE = "New coins!";
    private static final String EMAIL_TEXT = "New coin is coming: ";

    @Autowired
    private MailService mailService;

    @Autowired
    private CountryService countryService;

    @Override
    public void notifySubscribers(Coin coin) {
        Country country = countryService.read(coin.getCountry().getId());
        String[] subscribers = (String[]) country.getSubscribers().toArray();
        mailService.sendMail(FROM_ADDRESS, subscribers, EMAIL_TITLE, EMAIL_TEXT + coin.getDescription());
    }
}
