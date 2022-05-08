//package com.example.sample.sample.security.jwt;
//
//import com.example.sample.sample.entity.JWTClient;
//import com.example.sample.sample.security.jwt.JWTService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.filter.GenericFilterBean;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class MyCustomFilter extends OncePerRequestFilter {
////    @Override
////    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
////            throws IOException, ServletException {
////
////    }
//
//    /**
//     * JWT authentication and authorization
//     *
//     * @param request
//     * @param response
//     * @param filterChain
//     * @throws ServletException
//     * @throws IOException
//     */
//
//    @Autowired
//    JWTService jwtService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        /**
//         * invoke my DB -- to get the user as per request header --
//         * Call a thirdparty service
//         *                  --->(authenticate the user)
//         *
//         */
//        JWTClient authenticatedUser = jwtService.getAuthenticatedUser(request);
//
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                new UsernamePasswordAuthenticationToken(authenticatedUser, null, authenticatedUser.getAuthorities());
//        /**
//         * setting the same userName and password
//         */
//        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//        filterChain.doFilter(request, response);
//    }
//}
