package org.aibles.java.springboot.event_management_system.dto.response;

import lombok.Data;

@Data
public class ErrorResponse <T>{
    private String code;
    private long timestamps;
    private T error;

    public ErrorResponse(String code, long timestamps, T error) {
        this.code = code;
        this.timestamps = timestamps;
        this.error = error;

    }
}
