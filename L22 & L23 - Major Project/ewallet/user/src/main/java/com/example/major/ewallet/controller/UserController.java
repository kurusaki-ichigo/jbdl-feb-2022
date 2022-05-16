package com.example.major.ewallet.controller;


import com.example.major.ewallet.model.UserEntity;
import com.example.major.ewallet.request.CreateUserRequestDto;
import com.example.major.ewallet.service.UserService;
import com.example.major.ewallet.utils.ResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {


    @Autowired
    ResponseGenerator responseGenerator;
    @Autowired
    UserService userService;

    /**
     *
     * <p>
     *     User is created
     * </p>
     *
     *
     * @param requestDto
     * @return
     */
    @PostMapping("/user")
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserRequestDto requestDto){
        return responseGenerator.generateSuccessResponse(userService.createUser(requestDto), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(){
        return null;
    }


    /**
     * <p>
     *     This api should be accessed only by JWT Token and by notification service and not by other service
     * </p>
     * @param userId
     * @return
     */
    @PreAuthorize("hasRole(NOTIFICATION)")
    @GetMapping("/user")
    public UserEntity createUser(@RequestParam(value = "id", defaultValue = "0") Long userId){
        return userService.getUserById(userId);
    }

}
