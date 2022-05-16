package com.major.ewallet.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.ewallet.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserCreationListener {


    /**
     * send email for new user creation
     *  rest template (any call to be blocked) IO block call
     *          --- kafka --> pushing message to the queue
     *
     *          Producer ----------->[broker]<-------------Consumer
     *
     */
    private static final String USER_CREATED = "USER_CREATED";

    @Autowired
    ObjectMapper objectMapper;




    @Autowired
    JavaMailSender emailSender;


    @KafkaListener(topics = {USER_CREATED}, groupId = "notification_group")
    public void userCreation(String userInfo) throws JsonProcessingException {
        log.info(" ----------- message received ");
            // serialized user info  ===  message
        User user = objectMapper.readValue(userInfo, User.class);
        log.info(" user received {} ", user);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ewallet.notify.app@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject("Account Created");
        message.setText(" Hey .. your account has been successfully created with us ");
        emailSender.send(message);
    }



}
