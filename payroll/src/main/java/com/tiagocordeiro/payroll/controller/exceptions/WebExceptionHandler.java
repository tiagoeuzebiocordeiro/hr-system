package com.tiagocordeiro.payroll.controller.exceptions;

import com.tiagocordeiro.payroll.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorMessage> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(
                LocalDateTime.now(), ex.getMessage(), HttpStatus.NOT_FOUND.value(), request.getRequestURI()
        ));
    }
}
