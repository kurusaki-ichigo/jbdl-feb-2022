package com.example.L7.L7.controller;


import com.example.L7.L7.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class OnboardingController implements InitializingBean , DisposableBean {

    @Override
    public void destroy() throws Exception {
        // free up the memory
        // shut down executor service
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

    @Override
    public void afterPropertiesSet() throws Exception {
        UserInfo userInfo = createUser("Address", "hey@hey.com", 39810238, "JOEY");
        idToUserInfoMap.put(userInfo.getId(), userInfo);
        userInfo = createUser("Address1", "hey@.com", 390238, "MONIKA");
        idToUserInfoMap.put(userInfo.getId(), userInfo);
        userInfo = createUser("Address3", "hey@gmail.com", 39021238, "PHOEBE");
        idToUserInfoMap.put(userInfo.getId(), userInfo);
        userInfo = createUser("Address4", "hey@hotmail.com", 242390238, "CHANDLER");
        idToUserInfoMap.put(userInfo.getId(), userInfo);

    }

    private UserInfo createUser(String address, String email, Integer phoneNumber, String name){
        UserInfo userInfo = new UserInfo();
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhoneNumber(phoneNumber);
        userInfo.setName(name);
        return userInfo;
    }



//    @GetMapping("/users")
    @RequestMapping(value = "/api/v1/user", method = RequestMethod.GET)
    public List<UserInfo> getAllUsers(){
        log.info("Inside all users ");
        log.info(" idToUserMap {} ", idToUserInfoMap);
        if(CollectionUtils.isEmpty(idToUserInfoMap)){
            throw new RuntimeException(" No users ");
        }
        return idToUserInfoMap.values().stream().collect(Collectors.toList());
    }

    /**
     *
     * Try maximum -- for REST/ folder structure
     *
     *
     * Request param
     *              when you do not have certainintly and querying things
     *      vs
     *  Path Variable --
     *          when you do have certaininty about the operation being performed
     *              --- then use path
     *
     *
     * long integer /// why -- UUID - random ids
     *
     *
     *  get users with name like %oe%
     *
     *
     *
     *
     * @param id
     * @return
     */
    @GetMapping("/user")
    public UserInfo getUserById(@RequestParam(name = "id") String id){
        log.info("Inside userId ");
        log.info(" id {} idToUserMap {} ", id  ,idToUserInfoMap);
        if(CollectionUtils.isEmpty(idToUserInfoMap)){
            log.warn(" No users configured");
            throw new RuntimeException(" No users ");
        }

        UserInfo userInfo = idToUserInfoMap.get(id);
        if(Objects.isNull(userInfo)){
            log.error(" No user found ");
            throw new RuntimeException(" No valid user for id " + id);
        }

        return userInfo;
    }

    @GetMapping("/user")
    public ResponseEntity<UserInfo> getById(@RequestParam(name = "id") String id){
        log.info("Inside userId ");
        log.info(" id {} idToUserMap {} ", id  ,idToUserInfoMap);
        if(CollectionUtils.isEmpty(idToUserInfoMap)){
            log.warn(" No users configured");
            throw new RuntimeException(" No users ");
        }

        UserInfo userInfo = idToUserInfoMap.get(id);
        if(Objects.isNull(userInfo)){
            log.error(" No user found ");
            throw new RuntimeException(" No valid user for id " + id);
        }
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }


    /**
     * POST
     */
    /**
     *  Spring boot --> jackson (serializer and deserializer)
     *
     *          FE (json )  ---------> BE (spring boot application) (Java Object)  {@link UserInfo} | RequestBody
     *              (json) <-------(   )---  (java) {@link UserInfo}
     *
     * @RestController -- @Controller + {@link ResponseBody}
     *
     *
     *
     * @param userInfo
     * @return
     */
    @PostMapping("/user")
    public UserInfo createAUser(@RequestBody UserInfo userInfo){
//        UserInfo creatingUser = new UserInfo();
//        creatingUser.setPhoneNumber(userInfo.getPhoneNumber());
//        creatingUser.setName(userInfo.getName());
//        creatingUser.setEmail(userInfo.getEmail());
//        creatingUser.setAddress(userInfo.getAddress());
//        idToUserInfoMap.putIfAbsent(creatingUser.getId(), creatingUser);
        log.info("Inside createAUser {} " , userInfo);
        idToUserInfoMap.put(userInfo.getId(), userInfo);
        return userInfo;
    }


    @PutMapping("/user/{id}")
    public UserInfo modifyUser(@RequestBody UserInfo userInfo, @PathVariable(name = "id") String id){
        log.info("Inside modifyUser {} ", userInfo);

        if(CollectionUtils.isEmpty(idToUserInfoMap)){
            log.warn(" No users configured");
            throw new RuntimeException(" No users ");
        }

        UserInfo existingUserInfo = idToUserInfoMap.get(id);
        log.info(" existing user {}  :: updated by user {} ", existingUserInfo, userInfo);
        if(Objects.isNull(existingUserInfo)){
            log.error(" No user exist to update ");
            throw new RuntimeException(" No valid user for id " + id);
        }
        existingUserInfo.setPhoneNumber(userInfo.getPhoneNumber());
        existingUserInfo.setName(userInfo.getName());
        existingUserInfo.setEmail(userInfo.getEmail());
        existingUserInfo.setAddress(userInfo.getAddress());
        idToUserInfoMap.putIfAbsent(id, userInfo);
        return userInfo;
    }


    @DeleteMapping("/user/{id}")
    public UserInfo deleteUser(@PathVariable(name = "id") String id){
        log.info("Inside deleteUser ");
        return  idToUserInfoMap.remove(id);
    }

    @GetMapping("/dummy")
    public UserInfo dummy(){
        UserInfo userInfo = new UserInfo();
        /**
         * why its discouraged
         *  to use sout -- ?
         *
         *  --- Yes we do have flexibility in log to restrict the scope using log level.
         *  --
         *
         */
        String a = "Inside modifyUser"; //n
        String b = userInfo.toString(); // m
        String c = a+ b; // n or m
        StringBuilder sb = new StringBuilder(a);
        sb.append(b);
        c = sb.toString();

        System.out.println("Inside modifyUser  " + userInfo + LocalDateTime.now());
        log.error("Inside modifyUser {} ", userInfo);
        log.warn("Inside modifyUser {} ", userInfo);
        log.info("Inside modifyUser {} ", userInfo);
        log.debug("Inside modifyUser {} ", userInfo);
        log.trace("Inside modifyUser {} ", userInfo);
        return userInfo;
    }


    /**
     *
     *
    *
     *
     */




}
