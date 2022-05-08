package com.example.demo.kafka.implementation.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfigurations {

//    spring.kafka.producer.bootstrap-servers= localhost:9092,localhost:9093
//    spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
//    spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer

//    @Bean
//    public ProducerFactory<String , String> producerFactory(){
//        Map<String , Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//
//    @Bean
//    public KafkaTemplate<String , String> kafkaTemplate(){
//        KafkaTemplate<String, String> template = new KafkaTemplate<>(producerFactory());
//        return template;
//    }

    /**
     *
     *
     * Netflix oss
     * Eureka
     * Zuul
     * Ribbon
     *
     *
     * Aggregator (middle-man)
     *
     *
     *              -------> booking.com
     *                          ---> entire ticket information
     *
     *                              (Payment information, userinformation , order information)
     *
     *
     *
     *                      FE    -----> (Aggregator) --(combine result)
     *
     *                                          -----------------> ORDER (TICKET NUMER , ORDER ID , USER_ID)
     *                                          -----------------> USER (USER INFORMATION)
     *                                          ----------------> PAYMENT (CREDIT CARD INFORMATION , STATUS , USERID , ORDERID)
     *
     *
     *
     *
     *
     *
     * Zookeeper
     *  (zookeeper)
     *
     *
     *
     * brokers 0 (kafka)      (zookeeper)
     * brokers 1 (kafka)     (zookeeper)
     * brokers 2 (kafka)     (zookeeper)
     *
     */

}
