package com.leyla.kittenrescue.exception;

import com.leyla.kittenrescue.enums.ErrorCodeEnum;

import java.util.function.Supplier;

public class KittenRescueApiException extends RuntimeException implements Supplier<KittenRescueApiException> {

    private final ErrorCodeEnum errorCode;

    public KittenRescueApiException(ErrorCodeEnum errorCode) {
        super();
        this.errorCode = errorCode;
    }

    @Override
    public KittenRescueApiException get() {
        return this;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }
}
