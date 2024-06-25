package org.aibles.java.springboot.event_management_system.service;

public interface RedisService {
    void saveOTP(String username, String otp);

}
