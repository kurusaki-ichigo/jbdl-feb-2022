package com.example.jbdl.springbootsample;


import com.example.jbdl.springbootsample.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class OnbaordingController implements InitializingBean {

    int dbValue= 5;
    Map<String , UserInfo> userInfoMap = new HashMap<>();
    Map<Double, UserInfo> userIdToUserInfoMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        UserInfo sample = new UserInfo();
        sample.name = "RAM";
        userInfoMap.put(sample.name,sample);
        sample = new UserInfo();
        sample.name = "MIGUEL";
        userInfoMap.put(sample.name,sample);
        sample = new UserInfo();
        sample.name = "JOEY";
        userInfoMap.put(sample.name,sample);
        sample = new UserInfo();
        sample.name = "CHANDLER";
        userInfoMap.put(sample.name,sample);
        System.out.println(userInfoMap.toString());
        userIdToUserInfoMap = userInfoMap.entrySet().stream()
                .collect(Collectors.toMap(entry -> (entry.getValue()).id, Map.Entry::getValue));
    }
    /**
     *
     *      -- CRUD -- > create read update delete
     * Http methods
     *
     * -----
     *         GET
     *         POST
     *         PUT
     *         DELETE
     *
     *   IDEMPOTENCE is not related to multi threading ---
     *          ----------
     *  () Http method -- multiple times should not -- any difference on the resource object
     *          ---------
     *
     *         GET          --- idempotent -- (yes / no) == yes
     *                      -----> springboot app -(network call)-> DB
     *                                         if(object)     <-------------
     *                                     <------
     *                                     <------- (no object found)
     *                                     400 bad request
     *
     *         PUT         -- (yes / no) == yes
     *                      -- why idempotent ------ ?
     *                      --- replace the complete object
     *                      -----> springboot app -(network call)-> DB
     *                                     <------- (no object found)
     *                                     400 bad request
     *                          if(object)  <-------------
     *                          apply the changes
     *                                      --------------> persist in DB
     *                        <----- return <-------------
     *
     *
     *         DELETE           -- (yes / no) == yes
     *                          -- why idempotent ------ ?
     *                          -----> fetch the object
     *                          -- delete it if present
     *                          return reponse
     *                          -----> no object found
     *                              (204) : no conent found
     *
     *
     *         POST
     *
     *         better way
     *         idempotent key
     *              -- unique key
     *                  ---> add it over distributed lock..
     *                      (mysql -- relational DB)
     *                          ---> redis (key value store)
     *                                  (key , value , ttl) -- time to live (in seconds)
     *                                  (key would be automaticall evicted)
     *                                  HashMap with a ttl (redis)
     *
     *
     *
     *
     *
     *
     *          /add
     *              (
     *                 id : 12345,
     *                  value : 5
     *              )
     *              idempotency = 3829471297471397173
     *
     *              Multiple updates that are being performed
     *              (one of the update fails)
     *
     *                -- why idempotent ------ not idempotent
     *
                                -----> springboot app -(network call)-> DB
     *                                     <------- (no object found)
     *                                     400 bad request
     *                          if(object)  <-------------
     *                          apply the changes
     *                                      --------------> persist in DB
     *                        <----- return <-------------
     **     (hint -- uber solved this using idempotency key)
     *
     *
     *
     */



        @GetMapping("/hey")
        public String getResponse(){
            return "Hello World";
        }


    @GetMapping("/user")
    public String getResponse3(@RequestParam(name = "name") String name){
        System.out.println("name received " + name);
        UserInfo userInfo = userInfoMap.get(name);
        return Objects.isNull(userInfo) ? "No UserFound" : userInfo.toString();
    }


    @GetMapping("/user/{userId}")
    public String getResponse5(@PathVariable(name = "userId") double id){
        System.out.println("id received " + id);
        UserInfo userInfo = userIdToUserInfoMap.get(id);
        return Objects.isNull(userInfo) ? "No UserFound" : userInfo.toString();
    }


    /**
     * Distributed Lock
     *
     *          (ORDER_ID, response , ttl = 5 mins)
     *            (DB -- redis) / zookeeper for this
     *              |   |   |
     * s1   -(key)---|   |   |
     *              |   |
     * s2-------(key)-|    |
     *                  |
     * s3 --------(key)---|
     *
     *
     * @param number
     * @param idempotencyKey
     * @return
     */

    @PostMapping("/hey")
    public String getPostResponse(@RequestBody Integer number,
                                  @RequestHeader(name = "idempotencyKey") String idempotencyKey){
            int ttl = 5*60;
        /**
         *
         *
         * get key in redis
         *      if present return the cached response
         * if not present
         *      follow the below steps
         */

        /**
         * network call to a database
         */
        dbValue += number;

        /**
         *
         * whenever update to the same resource is being done
         * --evict the cache
         */

        /**
         * finally {
         *
         *              * set key in redis
         *          *  with a ttl (reply with value -- (currently ) with response)
         * }
         *
         */
        return "" + dbValue + " , " + ttl;





    }


    @RequestMapping(value = "/hey2", method = RequestMethod.GET)
    public String getResponse2(){
        return "I was doing just fine";
    }


}
