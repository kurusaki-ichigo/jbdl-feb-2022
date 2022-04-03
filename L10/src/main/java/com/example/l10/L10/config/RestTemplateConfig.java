package com.example.l10.L10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {



    /**
     * @Bean Vs @Component
     *
     *  ---> Bean is used to target type -- method
     *      ----> use it to define beans of objects which are part of source code
     *
     * --> @Component = used to targetType type - class , inteface , enum....
     *          --> use it to define out own classes as beans
     *
     * @return
     */

    @Bean("restTemplate")
    /**
     * scope -- is singleton
     */
    public RestTemplate restTemplate(){
        System.out.println(" ************ inside restTemplate ");
        return new RestTemplate();
    }

    /**
     *  IOC / application context
     *
     *   (_)
     *  |   |
     *          \___ (map of string and bean
     *                    restTemplate , $$restTemplate
     *                    restTemplate2, $$restTemplate_alfa)
     *
     *
     * @return
     */
    @Bean("restTemplate2")
    @Primary
    public RestTemplate restTemplate2(){
        System.out.println(" ----------- inside restTemplate2 ");
        return new RestTemplate();
    }

}
