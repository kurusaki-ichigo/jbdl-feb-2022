package com.example.l10.L10.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "lorem.impsum")
@Getter
@Setter
@ToString
@Slf4j
public class LoremIpsumConfig implements InitializingBean {


    String imageApi;


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(" --------- Properties : {} ", this);
    }
}
