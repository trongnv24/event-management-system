package org.aibles.java.springboot.event_management_system.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.java.springboot.event_management_system.dto.request.ActiveOtpRequest;
import org.aibles.java.springboot.event_management_system.dto.request.ActiveRequest;
import org.aibles.java.springboot.event_management_system.dto.response.BaseResponse;
import org.aibles.java.springboot.event_management_system.exception.InvalidRequestException;
import org.aibles.java.springboot.event_management_system.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/users")
@Slf4j
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/account:active")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse activateAccount(@RequestBody ActiveRequest request) {
        log.info(" === Start api new account activation === ");
        log.info(" === Request Body : {} === ", request);
        BaseResponse response = authService.activeAccount(request);
        log.info(" === Finish api new account activation, Account id === ");
        return response;
    }

    @PostMapping("/accounts/active-otp")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse activeAccount(@Valid @RequestBody ActiveOtpRequest request, BindingResult bindingResult) {
        log.info(" === Start api new account-active-otp === ");
        log.info(" === Request Body: {} === ", request);
        if (bindingResult.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> errors.append(error.getDefaultMessage()).append(" "));
            throw new IllegalArgumentException(errors.toString().trim());
        }
        BaseResponse response = authService.validateActiveAccountOtp(request);
        log.info("response: {}", response);
        log.info(" === Finish api account-active-otp, account-active-otp Id  {} === ");
        return response;
    }
}

