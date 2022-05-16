package com.example.major.ewallet.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JwtSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {



    @Autowired
    JWTAuthenticationFilter jwtAuthenticationFilter;
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
                .antMatchers(HttpMethod.GET, "/user/**")
                .and().authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and().addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .antMatcher("/**")
                .authorizeHttpRequests()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }


}
