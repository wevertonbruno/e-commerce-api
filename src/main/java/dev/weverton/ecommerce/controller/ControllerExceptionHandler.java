package dev.weverton.ecommerce.controller;

import dev.weverton.ecommerce.exceptions.EntityNotFoundException;
import dev.weverton.ecommerce.exceptions.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardException> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        StandardException err = new StandardException(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                Instant.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
