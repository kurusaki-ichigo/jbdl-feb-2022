package com.example.l8.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Configuration("demoConfig")
public class SampleConfig {

    /**
     *
     *  Container / Application Context
     *      (Spring Beans -- are stored as key value pair )
     *          where key is the name and value is the Instance
     *
     *
     * ( Spring _----SampleConfiguration = new SampleConfiguration())
     *
     * IOC container / Application Context
     *      (())
     *      | S1 |
     *      | _|
     * returning a random string
     *
     *
     *                  (writes)
     *      App ----> DB (master)
     *              |
     *              |
     *              |
     *              V   (reads)
     *          ---> DB (slave)
     *
     *
     *
     * @return
     */
    public String getString (){
        return UUID.randomUUID().toString();
    }




    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RestTemplate restTemplate3(){
        return new RestTemplate();
    }


    @Bean
    @Primary
    public RestTemplate restTemplate2(){
        return new RestTemplate();
    }


    /**
     *
     * CRUD api
     *  for wallet (Major)
     *  (in memory hashmap)
     *          --->
     *  CRUD wallet +
     *  Adding to money to wallet
     *  (in memory hashmap)
     *
     *  OR
     *
     *  Employee Salary Management
     * CRUD api
     *  for Employee (Major) -- UserInfo
     *  + salary management api
     *
     *  REST architecture
     *      /getUsers
     *
     *      Get Method /user
     *
     *  Music Library
     *      which have fav songs
     *
     */

    /**
     *  IOC container
     *
     *      (restTemplate, {instanceOfRestTemplate1})
     *      (restTemplate2, {instanceOfRestTemplate2})
     *
     *
     */

}
