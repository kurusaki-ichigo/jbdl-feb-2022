package com.example.l10.L10.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ToString
@Slf4j
public class LectureConfig implements InitializingBean {
    @Value("${lecture.name}")
    String name;


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(" --------- Properties : {} ", this);
    }
}
