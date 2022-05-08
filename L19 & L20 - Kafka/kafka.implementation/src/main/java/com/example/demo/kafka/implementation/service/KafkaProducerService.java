package com.example.demo.kafka.implementation.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {


    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String topic, String message) {
        log.info(" sending message --> topic {} message {} ", topic, message);
        kafkaTemplate.send(topic, message);
        log.info(" sent message {} ", message);
//        send.addCallback();


    }


}
