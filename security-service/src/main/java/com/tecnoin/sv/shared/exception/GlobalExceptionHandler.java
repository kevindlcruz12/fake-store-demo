package com.tecnoin.sv.shared.exception;

import com.tecnoin.sv.shared.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {
        return new ResponseEntity<>(ApiResponse.failure(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}