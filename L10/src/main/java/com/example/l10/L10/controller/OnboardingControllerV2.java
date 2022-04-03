package com.example.l10.L10.controller;

import com.example.l10.L10.config.RestTemplateConfig;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping(value = "/v2")
public class OnboardingControllerV2 {


    /**
     * field injection
     */
    @Autowired
    RestTemplateConfig demoTemplate;


    /**
     * in spring boot we cannot have two same apis
     *
     * (is a bit incomplete )
     *
     *
     *      we cannot have two same api end points + methods
     *      GET /user
     *      PUT /user
     *
     *  but only one of them will work
     *
     *  (statement )
     *      -- Correct (7)
     *
     *      -- incorrect (2)
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    @SneakyThrows
    @GetMapping(value = "/fetchImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] fetchImage(){
        log.info(" rest Template {} ", demoTemplate);
        return demoTemplate.restTemplate().getForObject("https://picsum.photos/id/1/200/300", byte[].class);
    }
}
