package org.aibles.java.springboot.event_management_system.dto.response;

import lombok.Data;


@Data
public class BaseResponse<T> {

    private String code;
    private long timestamp;
    private T data;

    public BaseResponse(String code, long timestamp, T data) {
        this.code = code;
        this.timestamp=timestamp;
        this.data = data;
    }
    public BaseResponse() {
        this.code = "success";
        this.timestamp = System.currentTimeMillis();
        this.data = null;
    }
}
