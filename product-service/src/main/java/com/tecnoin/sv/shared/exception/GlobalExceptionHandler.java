package com.tecnoin.sv.shared.exception;

import com.tecnoin.sv.shared.dto.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {
        return new ResponseEntity<>(ApiResponse.failure(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // Violación de restricción de base de datos (p.ej., clave única)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<Object>> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        ApiResponse<Object> apiResponse = ApiResponse.failure("Database error");
        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }

    // Argumento de método no válido (p.ej., formato incorrecto)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        ApiResponse<Object> apiResponse = ApiResponse.failure("Invalid method argument");
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    // Acceso denegado
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Object>> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        ApiResponse<Object> apiResponse = ApiResponse.failure("Access denied");
        return new ResponseEntity<>(apiResponse, HttpStatus.FORBIDDEN);
    }

}