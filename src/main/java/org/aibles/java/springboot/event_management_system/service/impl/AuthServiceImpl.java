package org.aibles.java.springboot.event_management_system.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.aibles.java.springboot.event_management_system.dto.request.ActiveRequest;
import org.aibles.java.springboot.event_management_system.dto.response.BaseResponse;
import org.aibles.java.springboot.event_management_system.entity.Account;
import org.aibles.java.springboot.event_management_system.entity.User;
import org.aibles.java.springboot.event_management_system.exception.InvalidRequestException;
import org.aibles.java.springboot.event_management_system.exception.NotFoundException;
import org.aibles.java.springboot.event_management_system.repository.AuthRepository;
import org.aibles.java.springboot.event_management_system.repository.UserRepository;
import org.aibles.java.springboot.event_management_system.service.AuthService;
import org.aibles.java.springboot.event_management_system.service.MailService;
import org.aibles.java.springboot.event_management_system.service.RedisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
@Transactional
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final RedisService redisService;
    private final MailService mailService;

    public AuthServiceImpl(AuthRepository authRepository, UserRepository userRepository, RedisServiceImpl redisService, MailServiceImpl mailService) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.redisService = redisService;
        this.mailService = mailService;
    }

    @Override
    public BaseResponse activeAccount(ActiveRequest request) {
        log.info(" === Start api activeAccount === ");
        log.info(" === Request Body: {} === ", request);
        String username = request.getUsername();
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidRequestException("Username cannot be blank or empty.");
        }
        log.info("Checking user existence in database.");
        Optional<Account> optionalAccount = authRepository.findByUsername(username.trim());
        if (!optionalAccount.isPresent()) {
            Map<String, String> errorDetails = new HashMap<>();
            errorDetails.put("message", "username: " + username + " not found");
            throw new NotFoundException(errorDetails);
        }

        Account account = optionalAccount.get();
        Optional<User> optionalUser = userRepository.findById(account.getUserId());
        if (optionalUser.isEmpty()) {
            Map<String, String> errorDetails = new HashMap<>();
            errorDetails.put("message", "User associated with username: " + username + " not found");
            throw new NotFoundException(errorDetails);
        }

        User user = optionalUser.get();
        String otp = generateOTP();
        redisService.saveOTP(username, otp);
        log.info("OTP {} saved to Redis for username {}", otp, username);
        mailService.sendOTP(user.getEmail(), otp);
        log.info("OTP sent to email: {}", user.getEmail());

        return new BaseResponse("success", System.currentTimeMillis(), null);
    }

    private String generateOTP() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }
}