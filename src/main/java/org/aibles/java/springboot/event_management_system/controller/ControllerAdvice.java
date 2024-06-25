package org.aibles.java.springboot.event_management_system.controller;

import org.aibles.java.springboot.event_management_system.dto.response.ErrolDetail;
import org.aibles.java.springboot.event_management_system.dto.response.ErrorResponse;
import org.aibles.java.springboot.event_management_system.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleNotFoundException(NotFoundException exception) {
        ErrolDetail errorDetail = new ErrolDetail(exception.getMessage());
        ErrorResponse<ErrolDetail> errorResponse = new ErrorResponse<>("not_found", System.currentTimeMillis(), errorDetail);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
