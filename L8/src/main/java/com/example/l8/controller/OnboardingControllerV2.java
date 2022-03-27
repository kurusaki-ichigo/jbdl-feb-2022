package com.example.l8.controller;

import com.example.l8.config.SampleConfig;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;


@RestController
@RequestMapping("/api/v2")
@Slf4j
public class OnboardingControllerV2 implements InitializingBean {


    @Autowired
    SampleConfig config;

    /**
     *  IOC container
     *
     *      (restTemplate, {instanceOfRestTemplate1})
     *      (restTemplate2, {instanceOfRestTemplate2})
     *      (onboardingControllerV2, {instanceOfOnboardingControllerV2})
     *
     *
     */
    @Autowired
    RestTemplate demoRestTemplate;

    @PostConstruct
    public void init(){
        /**
         * stuff
         */
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }





    /**
     *
     *
     *                                                  SpringBootApplication
     *        (tomcat)                                (dispatcherServlet)
     *  (Embeded Server)                                Thread .start()
     *                                                  Thread.stop()
     *                                                                  ------> will identify beans marked with
     *                                                                  @Restcontoller / @Controller
     *
     *
     *      (jetty)
     *
     *
     *      (undertow)
     *
     *  dispatcherServlet ---> RequestMappingHandlerMapping
     *                      <----
     *                  ------------------------------------------> ResourceHttpRequestHandler
     *                  <----------------------------------------
     *
     *
     *
     *       ---------------------------- Request Processing Works --------------------------
     *
     *
     *
     *
     *
     *
     *  IOC - Inversion of Control --
     *              (
     *                  Spring takes care of creating the beans
     *                          rather than us doing it manually
     *
     * @Component
     *
     *
     *               )
     *
     * @param args
     */
    public static void main(String[] args) {

    }
    @GetMapping("/dummy2")
    public String dummyApi(){
        /**
         * is there any benefit of creating these new objects ?
         *  - No
         *
         *
         */
        log.info(" config {} ", config);
        return config.toString();
    }


    public String dummyApi2(int a){
        /**
         * is there any benefit of creating these new objects ?
         *  - No
         *
         *
         */
        log.info(" config {} {} ", config, a);
        return config.toString();
    }


    @GetMapping(value = "/fetchImage", produces = MediaType.IMAGE_JPEG_VALUE)
    @SneakyThrows
    public byte[] fetchImages(){
        /**
         * using restTemplate
         */
        log.info(" restTemplate");


        return demoRestTemplate.getForObject("https://picsum.photos/id/1/200/300", byte[].class);

//        Request request = new Request.Builder()
//                .url("https://picsum.photos/id/1/200/300")
//                .method("GET", null)
//                .addHeader("Content-Type", "application/json")
//                .build();
//        Response response = .newCall(request).execute();
//        return response.body().bytes();
    }



}
