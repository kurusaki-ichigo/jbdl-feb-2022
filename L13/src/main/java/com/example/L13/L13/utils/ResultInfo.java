package com.example.L13.L13.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultInfo<T> {

    private ResultStatus status;
    private String statusCode;                        //error codes goes here
    private String statusMessage;                    //error message goes here
    private T result;
    private String traceId;

    public ResultInfo(T result) {
        this.result = result;
        this.status = ResultStatus.SUCCESS;
        this.statusCode = null;
        this.statusMessage = null;
        this.traceId = null;
    }


    public enum ResultStatus{
        SUCCESS,
        ACCEPTED,
        FAILED;
    }
}
