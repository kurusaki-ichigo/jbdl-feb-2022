package com.example.cache.cache.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfiguration {


//    @Bean
//    RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(){
//        return builder -> builder.withCacheConfiguration("userCache",
//                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(2)));
//    }


    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("redis-18654.c301.ap-south-1-1.ec2.cloud.redislabs.com");
        redisStandaloneConfiguration.setPort(18654);
        redisStandaloneConfiguration.setPassword("L9QFA3tht227EUd722u0939OhcUPZXrU");
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        return lettuceConnectionFactory;
    }


    @Bean
    public RedisTemplate<String , Object> redisTemplate(){
        RedisTemplate<String , Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(lettuceConnectionFactory());
        return redisTemplate;
    }



}
