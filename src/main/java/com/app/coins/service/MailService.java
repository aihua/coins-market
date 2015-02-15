package com.app.coins.service;

/**
 * Service for sending emails
 */
public interface MailService {

    /**
     * Send email to list of recipients
     *
     * @param from sender email
     * @param to recipients emails
     * @param subject mail
     * @param text mail body
     */
    void sendMail(String from, String[] to, String subject, String text);

    /**
     * Send email to one recipient
     *
     * @param from sender email
     * @param to recipient email
     * @param subject mail
     * @param text mail body
     */
    void sendMail(String from, String to, String subject, String text);
}
