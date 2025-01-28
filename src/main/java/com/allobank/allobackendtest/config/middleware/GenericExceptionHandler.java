package com.allobank.allobackendtest.config.middleware;

import com.allobank.allobackendtest.common.errors.ResourceNotFoundException;
import com.allobank.allobackendtest.model.errors.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@Slf4j
public class GenericExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GenericResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        log.error("Resource not found", e);
        return ResponseEntity.status(404).body(GenericResponse.error(e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GenericResponse> handleBadRequestException(Exception e) {
        log.error("Bad request", e);
        return ResponseEntity.badRequest().body(GenericResponse.error(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> handleException(Exception e) {
        log.error("Internal server error", e);
        return ResponseEntity.internalServerError().body(GenericResponse.error("Internal server error"));
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<GenericResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("Method argument type mismatch", e);
        return ResponseEntity.badRequest().body(GenericResponse.error(" %s invalid query param".formatted(e.getName())));
    }
}
