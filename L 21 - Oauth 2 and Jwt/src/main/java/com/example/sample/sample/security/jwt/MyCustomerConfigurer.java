//package com.example.sample.sample.security.jwt;
//
//
//import com.example.sample.sample.service.MyUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class MyCustomerConfigurer extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    MyUserService userService;
//    /**
//     *  Authentication
//     *
//     *  2 ways to login
//     *      1) username and password    --------> stored in your own database
//     *                                  -----> user microservice -- storing the user and password
//     *
//     *
//     *
//     *                                  best practise
//     *
//     *                                                              ------> not make call to login
//     *                             (BOOK service / SEARCH service)
//     *
//     *
//     *                              -----> (302)
//     *                              provide redirect_url = ()
//     *            FE-----> AUTH
//     *              ----> redirect_url (in request)             ------> User mirocser (302 , location == redirect_url)
//     *
//     *              Why ? redirect the call (but not made the call from our own microservice )
//     *              ????
//     *                  ---> Authentication layer changes (may be)
//     *                  --> Business logic
//     *                  --> code look
//     *
//     *
//     *
//     *
//     *      Use case
//     *              ----> we have to authenticate by making a call to the third party
//     *
//     *      2) Social Apps (gmail/ google , fb, spotify, snapchat , instagram and so on)
//     *
//     *
//     *
//     *
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        /**
//         * in memory authentication
//         *
//         */
////        auth.userDetailsService(userService);
//    }
//    /**
//     *
//     * Authorization
//     *
//     * ThirdParty (S2S)
//     *      Use case
//     *              ----> we have to authenticate by making a call to the third party
//     *
//     *
//     *
//     *  11 filters
//     *      ---   14 filters chain
//     *
//     *
//     * @param http
//     * @throws Exception
//     */
//    @Autowired
//    MyCustomFilter customFilter;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .requestMatchers()
//                .antMatchers("/**")
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated().and()
//                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//}
