package com.example.l10.L10.controller;


import com.example.l10.L10.config.LoremIpsumConfig;
import com.example.l10.L10.config.RestTemplateConfig;
import com.example.l10.L10.model.UserInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class OnboardingController implements InitializingBean , DisposableBean {

    @Override
    public void destroy() throws Exception {
        // free up the memory
        // shut down executor service
    }
    @Autowired
    LoremIpsumConfig ipsumConfig;

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
    @Autowired
    @Qualifier("restTemplate")
    RestTemplate restTemplate;


    /**
     * Some - to have predefined values
     *  -- benefit is to reload things in production without build (this is correct)
     * ---  properties and change with respect to that
     * -- configurations --specified in one place --> if you want to make a change -- you can easy make
     *
     *
     *
     *
     *
     *
     *
     */
    @Value("${lecture.name}")
    String lecture = "Spring Boot Basic Properties";


    public void doSomething(){

    }


    /**
     * (Spring Cloud)
     *
     *  --> application     (restarted)
     *      ---> network call
     *      (@Value -- default added in Refresh Scope)
     *      Bean --> explicitly add @RefreshScope
     *
     *                           ------------> Spring Cloud Config server (this is not bein restarted)
     *                                          (lec10.properties)
     *                                          (lec10-prod.properties)
     *                                          (lec10-staging.properties)
     *                                          (lec10-prod.properties)
     *                                          {                                                   {
     *
     *
     *                                              "application.name" : lecture 7         -->          "application.name" : lecture 10
     *                                          }                                                   }
     *
     *
     *
     *  layman terms
     *      -----> Application              ---> (network Call)
     *  (Refresh Context) <----                <---- Application Properties (response)
     *
     *
     *      -----> Application              ---> (network Call)  (Datasource -- mysql , redis, spring-cloud server )
     *  (Refresh Context) <----                <---- Application Properties (response)
     *
     *                                      (netflix archaius)
     *                                      (
     *                                          Connection Pool --> which will reload (with the time specified)
     *                                      )
     *
     *
     *
     *      */
    public void outOfContext(){

    }


    /**
     *
     * In memory Database (H2)
     *      -- HashMap (String , UserInfo)
     *
     * CRUD
     * Create -- POST                           ---               (201 ok)
     *                  {
     *                     all the fields / attributes except Id
     *                  }
     *
     *
     * READ -- GET (All)
     *                          {
     *                              it will be returning all the userInfo
     *                          }
     * READ -- GET (By Id)  input {id} ---------> returning the object
     *
     * UPDATE --- PUT      ---> modify the complete resource
     * DELETE -- Delete     ---> deleting a user
     *
     *
     *
     *  REST API        vs      *  SOAP
     *
     *   architecture style     (protocols)  , WSDL file
     *
     *
     * Application context does --> has
     *           (())
     *          |___|
     * IOC -- Inversion of control ---
     *              easy layman terms is -- you need not need to define the beans
     *                  --- spring takes care of it on its won...
     *
     *
     *
     *  How the methods are being invoked
     *      ------> any wild guess -- ???????
     *          --> IOC -- spring takes care of it
     *                  ----> spring identifies all the classes having @Component as
     *                  annotation around it either directly or indirectly
     *
                 (())  -------> bean of the onboardingController
     *          |___|     *
     *      Bean -- instance of class / properties ..
     *
     *
     *      Dependency inject
     *
     * @component
     *      C1      C2     C3       C4      C5
     *
     *        (())
     *       |__o1 , o2 , o3_|
     */

    Map<String , UserInfo> idToUserInfoMap = new HashMap<>();






    @GetMapping("/v2/dummy")
    public void dummyV2(){
        log.info("-------------> here ------------> {}", lecture);
    }

    /**
     * invoke 10
     *  -- 1 object vs 10 being created -- ?
     *
     * @return
     */
    @SneakyThrows
    @GetMapping(value = "/v1/fetchImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] fetchImage(){
        /**
         * Whats happening here --- ?
         *          ---- layman terms ---
         *              --==> it checks the annotation is call --> {@link Bean}
         *              --> fetch from IOC (scope)
         *              -->
         *
         *
         *
         *   (Singleton --> one bean created)
         *   (Prototype --> multiple bean created)
         */




//        RestTemplate restTemplate = restTemplateConfig.restTemplate();
        log.info(" rest Template {} ", restTemplate);
        return restTemplate.getForObject(ipsumConfig.getImageApi(), byte[].class);
    }


    /**
     *   Monolith
     *   vs
     *   Microservice
     *
     *
     *  ( SOAP )
     *
     *  FE -- api -- annotation with CROSS
     *
     *      end point of
     *
     *   Monolith - tightly coupled
     *   (each user stories -- start again from scratch)
     *
     *
     *   Microservice (divided in layers)
     *   (each service)
     *   (traceId and spanId)
     *
     *
     *     Monolith
     *     - single application (having everything , Zomato / delivery hero -- )
     *     (users, restaurants and menus , order , payment , invocing , bill , reconcilliation , merchant payment)
     *     method call
     *
     *     Microservice
     *     multiple apps
     *     (interacting with each other -- preference is over event bus, sync call too )
     *      (users, restaurants and menus , order , payment , invocing , bill , reconcilliation , merchant payment)
     *      network latency is added
     *      difficult to maintain transactions in microservices
     *
     *
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(" inside properties ");
    }
}
