package com.example.l8.controller;

import com.example.l8.config.SampleConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/api/v2")
public class OnboardingControllerV3 {


    SampleConfig config;

    RestTemplate restTemplate = new RestTemplate();

    /**
     *
     * what is singleton
     * OnboardingControllerV3 v3 = new Onbaording()
     *      --> api call
     *          --> method call
     *                  v3.dummyApi
     * @param config
     */

//    OnboardingControllerV3(SampleConfig config){
//        this.config = config;
//    }

    /**
     * will i be able to invoke the api
     *
     * and
     * what will be the config value
     *  - different ()
     *
     * @return
     *
     *  API are said to be same
     *      - if they have the same method type
     *      - if the have the same ned point
     *
     */
    @GetMapping("/dummy3")
    public String dummyApi(){
        log.info(" config {} inside V3 ", config);
        return config.toString();
    }


    /**
     *
     * CRUD
     *  A sample api to call a third party
     *
     *  UberEats/Zomato
     *      (microservices -- donot share database)
     *
     *      Monolith --
     *
     *
     *      A normal application
     *      Ticketing website
     *
     *        (UserFlow)
     *         CRUD -- different API with respect to USER (reporting/ invoicing / auditing )
     *
     *
     *
     *
     *      *
     *         APi for searchers -- per product
     *          ---> hold
     *              ---> book
     *                      ---> payment
     *                          ---> ticket generation
     *                              ---> invoicing
     *                                  ----> reconcilitation
     *
     *
     *
     *
     *
     *          Order
     *          creating order
    *]]
     *
     *
     *
     *          Payment
     *          collecting payment
     *
     *
     *
     *
     *
     *        ---> Register / login
     *
     *
     *              (Searcher)
     *                  ----> results from various vendors ()
     *                  (combine the results)
     *                              -----> markup (profit)
     *
     *              --> Destination (to / from)
     *
     *                                  ---> book
     *                                              ----> payment methods
     *                                                          -----> payment
     *                                                                  --------> order is generated
     *
     *                                                                          -----> receive a ticket
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */


}
