package com.example.major.ewallet.utils;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.example.major.ewallet.utils.ResponseInfo.ResultStatusCode.FAILED;
import static com.example.major.ewallet.utils.ResponseInfo.ResultStatusCode.SUCCESS;


@Component
public class ResponseGenerator {


    @Autowired
    Gson gson;


    public <T> ResponseEntity<String> generateSuccessResponse(T data, HttpStatus httpStatus){
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setData(data);
        responseInfo.setStatusCode(SUCCESS);
        return new ResponseEntity<String>(gson.toJsonTree(responseInfo).toString(), httpStatus);
    }

    public <T> ResponseEntity<String> generateFailedResponse(T data, HttpStatus httpStatus){
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setData(data);
        responseInfo.setStatusCode(FAILED);
        return new ResponseEntity<String>(gson.toJsonTree(responseInfo).toString(), httpStatus);
    }

}
