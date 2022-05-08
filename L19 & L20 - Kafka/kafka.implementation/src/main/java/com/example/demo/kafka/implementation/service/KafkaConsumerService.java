package com.example.demo.kafka.implementation.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {


    @KafkaListener( topics = "payment", groupId = "group-id")
    public void receivedMessage(@Payload ConsumerRecord<String , String> record){
        log.info(" received message ---> with topic {} , value {} ", record.topic(), record.value());
    }


    @KafkaListener( topics = "demo", groupId = "group-id")
    public void receivedMessage(@Payload String message){
        log.info(" received message for topic demo ---------> {} " , message);
    }


    @KafkaListener( topics = "demo", groupId = "group-id2")
    public void receivedMessage2(@Payload String message){
        log.info(" received message for topic demo ---------> {} " , message);
    }

    /**
     * Whats the use of group Id
     *          (group of people performing a task)
     *
     *
     *
     *   demo 100
     *                                              Broker                                          consumer group (NYPD)
     *   publisher ---> message                 (key --topic , value --message)
     *                                                                                              consumer group (FBI)
     *
     *
     *
     *                                              Broker                                          consumer group (Recommendation)
     *   publisher ---> message                 (key --topic , value --message)
     *                                                                                              consumer group (Auditing)
     *                                                                                              consumer group (Invoice /notification)
     *
     *
     *
     *
     *              within a consumer group
     *                      consumers -----------> directly proportional to no of partitions
     *
     *
     *                      [one single queue ---> 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]               ---> consumer
     *                                          [                      3 | 2 | 1  | 0  ]        ------ offset
     *                       partition zero  [one  queue ---> 10,  4, 3, 2, 1]                        ---> consumer 1
     *                       partition one   [second queue ---> 9, 8, 7, 6, 5]                     ---> consumer 2
     *
     *
     *
     */

}
