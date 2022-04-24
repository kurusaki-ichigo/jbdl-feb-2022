package com.example.cache.cache.controller;

import com.example.cache.cache.entities.UserInfo;
import com.example.cache.cache.request.CreateUserRequestDto;
import com.example.cache.cache.service.UserService;
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
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> createAUser(@Valid @RequestBody CreateUserRequestDto userInfo){
        log.info("Request Received {} " , userInfo);
        return new ResponseEntity<>(userService.createUser(userInfo), HttpStatus.CREATED);
    }


    /**
     * Admin
     * @param
     * @return
     */
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserInfo>> fetchAllUsers(
            @RequestParam(required = false, defaultValue = "0") Integer pageNumber){
        log.info("Request Received for fetching all users  ");
        return new ResponseEntity<>(userService.fetchAllUsers(pageNumber), HttpStatus.OK);
    }


    @GetMapping(value = "/user/{emailId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<UserInfo>> fetchUserByEmail(@PathVariable String emailId){
        log.info("Request Received for fetching user by {}  ", emailId);
        return new ResponseEntity<>(userService.fetchOneById(emailId), HttpStatus.OK);
    }
}
