package io.pragra.learning.mvc2.rest;

import io.pragra.learning.mvc2.Error;
import io.pragra.learning.mvc2.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ReponseAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<?> handleNotFound(RuntimeException ex, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new Error("404",ex.getMessage(), Instant.now())
        );
    }
}
