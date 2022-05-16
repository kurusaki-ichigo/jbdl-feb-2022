package com.example.major.ewallet.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.MDC;

@Getter
@Setter
@AllArgsConstructor
public class ResponseInfo <T>{

    T data;
    ResultStatusCode statusCode;
    String traceId;



    public ResponseInfo(){
        this.traceId = MDC.get("traceId");
    }

    enum ResultStatusCode {
        SUCCESS,
        FAILED,
        PENDING
    }

}