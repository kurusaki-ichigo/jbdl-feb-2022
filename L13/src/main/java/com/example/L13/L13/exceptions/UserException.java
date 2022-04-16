package com.example.L13.L13.exceptions;

import com.example.L13.L13.models.StatusCode;
import lombok.Getter;

@Getter
public class UserException extends RuntimeException{

    StatusCode statusCode;
    public UserException(StatusCode statusCode){
        super(statusCode.getExceptionMessage());
        this.statusCode = statusCode;
    }

}
