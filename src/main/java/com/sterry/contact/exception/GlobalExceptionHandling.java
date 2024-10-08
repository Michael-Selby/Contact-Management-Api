package com.sterry.contact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Map<String,String>> handleException(MethodArgumentNotValidException ex) {
        Map<String,String> errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error)->{
            errors.put(error.getField(),error.getDefaultMessage());
        });
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);





    }



}
