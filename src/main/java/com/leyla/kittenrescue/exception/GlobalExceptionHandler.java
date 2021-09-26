package com.leyla.kittenrescue.exception;

import com.leyla.kittenrescue.enums.ErrorCodeEnum;
import com.leyla.kittenrescue.model.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(KittenRescueApiException.class)
    public final ResponseEntity<ErrorResponse> handleBalanceApiException(KittenRescueApiException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setDateTime(LocalDateTime.now());
        errorResponse.setCode(ex.getErrorCode().getCode());
        errorResponse.setMessage(ex.getErrorCode().getMessage());
        errorResponse.setSessionId(request.getSessionId());
        log.error("KittenRescueApiException ", ex);
        return new ResponseEntity<>(errorResponse, ex.getErrorCode().getHttpStatus());
    }

    @ExceptionHandler(BindException.class)
    public ErrorResponse handleBindException(BindException ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(ErrorCodeEnum.BAD_REQUEST_ERROR.getCode(),
                                                  ErrorCodeEnum.BAD_REQUEST_ERROR.getMessage().concat(ex.getMessage()), request.getSessionId(),
                                                  LocalDateTime.now());

        log.error("BAD_REQUEST_ERROR", ex);
        return message;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorResponse message = new ErrorResponse(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getCode(), ErrorCodeEnum.INTERNAL_SERVER_ERROR.getMessage(),
                                                  request.getSessionId(), LocalDateTime.now());

        log.error("INTERNAL_SERVER_ERROR", ex);
        return message;
    }
}
