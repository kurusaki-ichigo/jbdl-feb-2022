package com.example.major.ewallet.advice;

import com.example.major.ewallet.utils.ResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    ResponseGenerator responseGenerator;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> generateErrorResponse(){
        return responseGenerator.generateFailedResponse("Exception Received", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
