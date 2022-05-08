package com.example.demo.kafka.implementation.controller;

import com.example.demo.kafka.implementation.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class KafkaController {

        @Autowired
        KafkaProducerService producerService;


        @GetMapping(value = "/kafka/publish")
        public void sendMessageToKafka(@RequestParam("topic") String topic , @RequestParam("message") String message){
                producerService.sendMessage(topic, message);
        }
}
