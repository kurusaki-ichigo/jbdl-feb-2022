package com.example.L13.L13.exceptions;

import com.example.L13.L13.models.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class BookException extends RuntimeException{

    StatusCode statusCode;
    public BookException(StatusCode statusCode){
        super(statusCode.getExceptionMessage());
        this.statusCode = statusCode;
    }

}
