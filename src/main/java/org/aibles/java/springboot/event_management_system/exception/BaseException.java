package org.aibles.java.springboot.event_management_system.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends  RuntimeException{
    private  String message;
    private  String id;
    private  String objectName;
    private Timestamp timestamp;

    public BaseException(String message) {
        super(message);
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

