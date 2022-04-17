package com.example.L16.L16.security;

import com.example.L16.L16.entities.UserInfo;
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
     *  -- authenticated and authorized
     *
     *  Authentication vs Authorization
     *
     *  -- whether user is valid or not / exists                                        -- 401
     *  -- Authorization - whether a given resource (api) is allowed to a user or not   -- c
     *
     *
     *
     *  FE ---> [ tomcat (spring boot application)] ----> database
     *
     *
     *   FE --->         [ |-|       tomcat (Dispatcher servlet)                                      ----> database
     *                     | |    -------->     [ functions -- api end points] ]
     *                     | |
     *                     |_|------> spring security filter chain
     *
     *
     *
     *                     [ | |(Authentication) | | | | (Authorization)| | | |]
     *
     *                     --> in memory authentication and authorization (done)
     *
     *                      --> we would use our own database  (done)
     *                      ---> we would be having different microservice all together from where we would be getting user object
     *                           (done)
     *                     Inject filters in-between ( (done))
     *
     *
     *
     *          Application Context
     *
     *          User Context --> (User object)SecurityContextHolder.getContext().getAuthentication().getPrincipal()
     *          {@link  User#getAuthorities()} ---> would be same as permission (user roles)
     *                      ----> different ways to do same thing
     *
     *
     *
     *          CSRF - Cross site request forgery
     *
     *          sbi - kyc has expired -- kindly click on the following link
     *
     *          (payyytm.com // sbii.com)
     *          html content same as that of original website
     *          {
     *              userName :
     *              Password :
     *
     *                                           -----------_> ontow their own database
     *                                          -------> paytm / sbi's api  --> this call would fail (as they do not have token)
     *                                                                      ----------> login into the user account
     *          }
     *
     *
     *
     *
     *
     *
     *
     * @return
     */


    @GetMapping(value = "/welcome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> welcomeMessage(){
        /**
         * Application / bean context --
         */
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        return new ResponseEntity<>(" Welcome user " + principal, HttpStatus.OK);
    }


    @GetMapping(value = "/merchant", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> welcomeMerchant(){
        /**
         * Application / bean context --
         */
        UserInfo principal = (UserInfo)SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        return new ResponseEntity<>(" Welcome merchant " + principal.getUsername(), HttpStatus.OK);
    }

    @GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> welcomeCustomer(){
        /**
         * Application / bean context --
         */
        UserInfo principal = (UserInfo)SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        return new ResponseEntity<>(" Welcome customer " + principal.getUsername(), HttpStatus.OK);
    }



    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> welcomeUser(){
        return new ResponseEntity<>(" Welcome user ", HttpStatus.OK);
    }

}
