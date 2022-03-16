package com.sainntt.coffeapi.controller;

import com.sainntt.coffeapi.dto.ExceptionDto;
import com.sainntt.coffeapi.exception.CoffeeNotFoundException;
import com.sainntt.coffeapi.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleCoffeeNotFoundException(CoffeeNotFoundException exception, WebRequest request) {
        return
                new ResponseEntity<>(
                        new ExceptionDto(new Date(), exception.getMessage(), request.getDescription(false)),
                        HttpStatus.NOT_FOUND);
    }
}
