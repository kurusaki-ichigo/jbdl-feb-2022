package com.example.L15.L15.controller;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

@Component

/**
 * you can specify ordering of beans with @Order
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    /**
     *
     *   UserMicroservice (different completely)
     *      --> querying the service running at different (different microserice)
     *              (service would return the user object)
     *     __> set the user into the security context
            COntroller layer or here too
     *          ---> you can specify which resource (apis) -- you want to authenticate for a user     *
     *
     *
     *
     *
     *   UserMicroservice (within this)
     *
     *   ---> datasource with username and password and get its roles and then at
     *      COntroller layer or here too
     *          ---> you can specify which resource (apis) -- you want to authenticate for a user
     *
     *
     *
     *
     * Authentication
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }
    /**
     * Authorization
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    }

}
