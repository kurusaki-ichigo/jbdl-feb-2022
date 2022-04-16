package com.example.L13.L13.commons;

import com.example.L13.L13.models.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.MDC;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo <T>{

    T data;
    ResultStatusCode statusCode;
    String message;
    String exceptionCode;
    String traceId;



    public ResponseInfo(StatusCode statusCode){
        this.exceptionCode = statusCode.getExceptionCode();
        this.message = statusCode.getExceptionMessage();
        this.traceId = MDC.get("traceId");
    }

    enum ResultStatusCode {
        SUCCESS,
        FAILED,
        PENDING
    }

}
