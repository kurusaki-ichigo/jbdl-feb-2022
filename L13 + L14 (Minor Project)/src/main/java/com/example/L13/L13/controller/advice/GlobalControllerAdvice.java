package com.example.L13.L13.controller.advice;

import com.example.L13.L13.commons.ResponseInfo;
import com.example.L13.L13.exceptions.*;
import com.example.L13.L13.models.StatusCode;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {


    @Autowired
    Gson gson;

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> generateBadRequestResponse() {
        return new ResponseEntity<String>(" Bad Request as book not found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookExistsException.class)
    public ResponseEntity<String> generateBadRequestResponseWhenBookExists() {
        return new ResponseEntity<String>(" Bad Request as book not found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConnectionErrorException.class)
    public ResponseEntity<String> generateConnectionError() {
        return new ResponseEntity<String>(" connection to db was lost", HttpStatus.SERVICE_UNAVAILABLE);
    }


    @ExceptionHandler(BookException.class)
    public ResponseEntity<String> generateBookException(BookException exception) {
        StatusCode statusCode = exception.getStatusCode();
        ResponseInfo resultInfo = new ResponseInfo(statusCode);
        return new ResponseEntity<>(gson.toJsonTree(resultInfo).toString(), statusCode.getHttpStatus());
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> generateUserException(UserException exception) {
        StatusCode statusCode = exception.getStatusCode();
        ResponseInfo resultInfo = new ResponseInfo(statusCode);
        return new ResponseEntity<>(gson.toJsonTree(resultInfo).toString(), statusCode.getHttpStatus());
    }

}
