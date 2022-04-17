package com.example.external.security1.controller;

import com.example.external.security1.context.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1")
public class SampleController {


    @GetMapping(value = "/merchant", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> welcomeMerchant(){
        UserInfo principal = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(" Welcome merchant " + principal.getEmail(), HttpStatus.OK);
    }


}
