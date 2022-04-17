package com.example.external.security1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyAppSecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Autowired
    MyAuthenticalFilter authenticalFilter;
    /**
     * Authorization -- from this application
     * ---> invoke UserService
     *  ---> get UserInfo
     *          ----> and set the userINfo into our application context
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .requestMatchers()
                .antMatchers("/**")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated().and()
                .addFilterBefore(authenticalFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
