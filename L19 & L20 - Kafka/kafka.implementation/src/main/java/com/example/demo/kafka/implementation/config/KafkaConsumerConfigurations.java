package com.example.demo.kafka.implementation.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfigurations {

//    spring.kafka.consumer.enable-auto-commit=true
//    spring.kafka.consumer.bootstrap-servers= localhost:9092,localhost:9093
//    spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
//    spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
//    spring.kafka.consumer.group-id=group_id


//
//    @Bean
//    public ConsumerFactory<String , String> consumerFactory(){
//        Map<String , Object> configProps = new HashMap<>();
//        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093");
//        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringDeserializer.class);
//        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringDeserializer.class);
//        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
//        configProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
//        return new DefaultKafkaConsumerFactory<>(configProps);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String , String> kafkaListenerContainerFactory(){
//        ConcurrentKafkaListenerContainerFactory<String  , String> kafkaListenerContainerFactory = new
//                ConcurrentKafkaListenerContainerFactory<>();
//        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
//        return kafkaListenerContainerFactory;
//    }
}
