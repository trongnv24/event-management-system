package org.aibles.java.springboot.event_management_system.controller;

import lombok.extern.slf4j.Slf4j;
import org.aibles.java.springboot.event_management_system.dto.request.ActiveRequest;
import org.aibles.java.springboot.event_management_system.dto.response.BaseResponse;
import org.aibles.java.springboot.event_management_system.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@Slf4j
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/account:active")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse activateAccount(@RequestBody ActiveRequest request){
       log.info(" === Start api new account activation === ");
       log.info(" === Request Body : {} === ", request);
       BaseResponse response = authService.activeAccount(request);
       log.info(" === Finish api new account activation, Account id === ");
       return response;
    }
}
