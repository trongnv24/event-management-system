package org.aibles.java.springboot.event_management_system.service;

import org.aibles.java.springboot.event_management_system.dto.request.ActiveOtpRequest;
import org.aibles.java.springboot.event_management_system.dto.request.ActiveRequest;
import org.aibles.java.springboot.event_management_system.dto.response.BaseResponse;


public interface AuthService {
    BaseResponse activeAccount(ActiveRequest request);
    BaseResponse validateActiveAccountOtp(ActiveOtpRequest request);

}
