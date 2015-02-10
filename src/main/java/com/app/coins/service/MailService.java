package com.app.coins.service;

/**
 * TODO: Add comment
 */
public interface MailService {

    void sendMail(String from, String[] to, String subject, String text);
}
