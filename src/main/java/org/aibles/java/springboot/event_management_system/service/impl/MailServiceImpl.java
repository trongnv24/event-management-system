package org.aibles.java.springboot.event_management_system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.aibles.java.springboot.event_management_system.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Async
    public void sendOTP(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your One-Time Password (OTP)");
        message.setText("Here is your OTP to access the service: " + otp);
        mailSender.send(message);
    }
}
