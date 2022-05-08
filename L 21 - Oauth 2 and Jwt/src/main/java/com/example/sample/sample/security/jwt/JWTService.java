package com.example.sample.sample.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.sample.sample.entity.JWTClient;
import com.example.sample.sample.models.S2SClient;
import com.example.sample.sample.repository.JWTRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class JWTService {


    @Autowired
    JWTRepository repository;


    public JWTClient getAuthenticatedUser(HttpServletRequest request){
            return validateTokenAndReturnClient(request);
    }


    private JWTClient validateTokenAndReturnClient(HttpServletRequest request){
        // JWT TOKEN
        String jwtToken = request.getHeader("x-jwt-token");
        // BOOK service
        String client = request.getHeader("x-client");

        log.info(" verifying the token {} for client {} ", jwtToken, client);
        if(!isValid(jwtToken, client)){
            throw new JWTVerificationException("No Client found");
        }

        Optional<JWTClient> dbClient = repository.findByClient(S2SClient.valueOf(client));
        if(dbClient.isEmpty()){
            throw new JWTVerificationException("No Mapping Present for the client");
        }

        JWTClient jwtClient = dbClient.get();
        /**
         * method call
         */
//        jwtClient.getAuthorities();
        DecodedJWT decode = JWT.decode(jwtToken);
        Map<String, Claim> claims = decode.getClaims();
        Claim name = claims.get("name");
        if(name.isNull() || !name.asString().equals(client)){
            throw new JWTVerificationException("Invalid Access");
        }

        decode.getHeaderClaim("alg");

        /**
         * time stamp filtering
         *
         * algo check here
         *
         */

        return jwtClient;
    }

    private boolean isValid(String jwtToken, String client) {
        if(StringUtils.isEmpty(client) || StringUtils.isEmpty(jwtToken)){
            return false;
        }

        try {
            S2SClient.valueOf(client);
        } catch (Exception exception){
            return false;
        }
        return true;
    }


}
