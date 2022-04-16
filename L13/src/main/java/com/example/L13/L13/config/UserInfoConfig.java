package com.example.L13.L13.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@ToString
@Getter
@Setter
public class UserInfoConfig implements InitializingBean {

    @Value("${user-info.configuration.book-quota}")
    Integer bookQuota;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-----------> UserInfoConfig ----> {}", this);
    }
}
