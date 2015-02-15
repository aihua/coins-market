package com.app.coins.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Implementation of service for sending emails
 */
@Service
public class MailServiceImpl implements MailService {

    private final static Logger Logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendMail(String from, String[] to, String subject, String text) {
        Logger.info("Starting send email from: " + from + " to: " + to);
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }

    @Override
    public void sendMail(String from, String to, String subject, String text) {
        Logger.info("Starting send email from: " + from + " to: " + to);
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
}
