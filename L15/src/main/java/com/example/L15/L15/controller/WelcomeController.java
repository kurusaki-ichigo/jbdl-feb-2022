package com.example.L15.L15.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WelcomeController {


    /**
     *
     * On adding spring security dependency
     * 1) --> would every api be authenticated
     *  2)--> would only welcome api be authenticated
     *  3)--> nothing would happen
     *
     *
     *  3)
     *  1) ---
     *
     * @return
     */


    @GetMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> welcomeMessage(){
        /**
         * Application / bean context --
         */
        User principal = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        return new ResponseEntity<>(" Welcome user " + principal.getUsername(), HttpStatus.OK);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> welcomeUser(){
        return new ResponseEntity<>(" Welcome user ", HttpStatus.OK);
    }

}
