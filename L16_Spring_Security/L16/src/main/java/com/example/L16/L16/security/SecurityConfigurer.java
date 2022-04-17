package com.example.L16.L16.security;

import com.example.L16.L16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration

/**
 * you can specify ordering of beans with @Order
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@Order(2)
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
     *
     *
     *
     */

    String CHEF = "CHEF";
    String ACTOR = "ACTOR";
    String ACCOUNTANT = "ACCOUNTANT";
    String CUSTOMER = "CUSTOMER";
    String MERCHANT = "MERCHANT";

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * this is inMemory Authentication
         *
         */
//        auth.inMemoryAuthentication()
//                .withUser("Monika")
//                .password("$2a$10$X.yJMCsKg7.4koTB8EHf5eW4lgR7Z.O7kxUVhTDNhPsKsELeR50mu")
//                .authorities(CHEF)
//                .and()
//                .withUser("Joey")
//                .password("$2a$10$NQRIqx2TAGKkV18sJ8h7e.zOJxFuu7A67JANnqWyeJsmNuKpVaHsy")
//                .authorities(ACTOR)
//                .and()
//                .withUser("Chandler")
//                .password("$2a$10$ysyUhbkHRnfLFzr.N5tAWOm.KCDJANFIJ2LIgKM6bQez4ZCBpdTOi")
//                .authorities(CUSTOMER, ACCOUNTANT)
//                .and()
//                .withUser("Gunter")
//                .password("$2a$10$8eJR2/jfpfvkWVFstYewdOpJxteJgIyTzMJ8gaxctludfThhcxzcW")
//                .authorities(MERCHANT);

        auth.userDetailsService(userService);
    }


    /**
     *
     * DB -- "funny@123" -- user table
     *
     *
     */

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("inlovewithrachel"));
        System.out.println(encoder.encode("funny@123"));
        System.out.println(encoder.encode("whatday"));
        System.out.println(encoder.encode("chef@123"));

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    /**
     * Authorization
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/merchant/**").hasAuthority(MERCHANT)
                .antMatchers("/customer/**").hasAuthority(CUSTOMER)
                .antMatchers("/**").permitAll()

                /**
                 * ensure wild card is towards the end
                 */
                .and()
                .formLogin();
    }

}
