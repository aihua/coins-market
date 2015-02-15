package com.app.coins.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/test-context.xml")
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    @Ignore
    public void testSendMail() throws Exception {
        mailService.sendMail("some@email.com", new String[]{"Papercut@user.com"}, "Test!!!!!", "Cool text!");
    }
}