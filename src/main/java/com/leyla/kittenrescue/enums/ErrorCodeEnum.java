package com.leyla.kittenrescue.enums;

import org.springframework.http.HttpStatus;

public enum ErrorCodeEnum {
    INTERNAL_SERVER_ERROR(1000, "Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1002, "Field validation error: ", HttpStatus.BAD_REQUEST);

    private int code;

    private String message;

    private HttpStatus httpStatus;

    ErrorCodeEnum(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
