package com.example.l8.advice;

import com.example.l8.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler( value = UserNotFoundException.class)
    public String toString() {
        return super.toString();
    }
}
