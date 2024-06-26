package org.aibles.java.springboot.event_management_system.controller;

import org.aibles.java.springboot.event_management_system.constant.CodeResponse;
import org.aibles.java.springboot.event_management_system.dto.response.BaseResponse;
import org.aibles.java.springboot.event_management_system.dto.response.ErrorDetail;
import org.aibles.java.springboot.event_management_system.dto.response.ErrorResponse;
import org.aibles.java.springboot.event_management_system.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;



@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleNotFoundException(NotFoundException exception) {
        ErrorDetail errorDetail = new ErrorDetail(exception.getMessage());
        ErrorResponse<ErrorDetail> errorResponse = new ErrorResponse<>("not_found", System.currentTimeMillis(), errorDetail);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestException(InvalidRequestException exception) {
        ErrorDetail errorDetail = new ErrorDetail(exception.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("invalid_otp", System.currentTimeMillis(), errorDetail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}