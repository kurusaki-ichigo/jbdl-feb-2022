package com.example.sample.sample.controller;

import com.example.sample.sample.entity.JWTClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@Slf4j
public class DemoController {



    @GetMapping("/user")
    public Map<String,  Object> getUserDetails(@AuthenticationPrincipal OAuth2User user){
        log.info(" got user with details {} ", user);
        return Collections.singletonMap("name", user.getName());
    }


    @PreAuthorize("hasRole('BOOK') OR hasRole('INVOICE')")
//    @Secured({"ROLE_BOOK", "ROLE_INVOICE"})
    @GetMapping("/book")
    public String bookMicroservice(){
        return "inside book method";
    }


    @PreAuthorize("hasRole('INVOICE')")
    @GetMapping("/invoice")
    public String invoiceMicroservice(){
        return "inside invoice method";
    }

}
