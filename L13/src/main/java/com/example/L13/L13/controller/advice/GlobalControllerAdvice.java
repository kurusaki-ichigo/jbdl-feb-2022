package com.example.L13.L13.controller.advice;

import com.example.L13.L13.exceptions.BookExistsException;
import com.example.L13.L13.exceptions.BookNotFoundException;
import com.example.L13.L13.exceptions.ConnectionErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {


    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> generateBadRequestResponse(){
        return new ResponseEntity<String>(" Bad Request as book not found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookExistsException.class)
    public ResponseEntity<String> generateBadRequestResponseWhenBookExists(){
        return new ResponseEntity<String>(" Bad Request as book not found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConnectionErrorException.class)
    public ResponseEntity<String> generateConnectionError(){
        return new ResponseEntity<String>(" connection to db was lost", HttpStatus.SERVICE_UNAVAILABLE);
    }

}
