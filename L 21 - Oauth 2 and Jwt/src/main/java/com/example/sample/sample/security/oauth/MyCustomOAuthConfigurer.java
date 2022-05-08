package com.example.sample.sample.security.oauth;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class MyCustomOAuthConfigurer extends WebSecurityConfigurerAdapter {


        @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(a ->
                        a.antMatchers("/","/error", "/webjars/**").permitAll()
                                .anyRequest().authenticated())
                .exceptionHandling(e ->
                        e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .csrf(c ->
                        c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))

//                .logout(l ->
//                        l.logoutSuccessUrl("/").permitAll())
                .oauth2Login();
    }
}
