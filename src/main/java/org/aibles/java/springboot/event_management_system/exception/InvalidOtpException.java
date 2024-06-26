package org.aibles.java.springboot.event_management_system.exception;

public class InvalidOtpException extends RuntimeException{
    public InvalidOtpException(String message) {
        super(message);
    }
}
