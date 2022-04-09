package com.example.L11.L11.controller;

import com.example.L11.L11.model.enities.UserInfo;
import com.example.L11.L11.model.requests.CreateUserRequestDto;
import com.example.L11.L11.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class OnboardingController {


    /**
     * CRUD
     * {POST} /user
     * {GET} /user
     * {PUT} /user
     * {DELETE} /user
     */

    @Autowired
    UserService userService;


    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> createAUser(@Valid @RequestBody CreateUserRequestDto userInfo){
        log.info("Request Received {} " , userInfo);
        return new ResponseEntity<>(userService.createUser(userInfo), HttpStatus.CREATED);
    }


    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserInfo>> fetchAllUsers(){
        log.info("Request Received for fetching all users  ");
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }


    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<UserInfo>> fetchUserById(@RequestParam( name = "userId") String id){
        log.info("Request Received for fetching all users  ");
        return new ResponseEntity<>(userService.fetchOneById(id), HttpStatus.OK);
    }

}
