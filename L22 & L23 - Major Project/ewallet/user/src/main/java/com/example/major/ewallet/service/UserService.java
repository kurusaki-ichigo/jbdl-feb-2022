package com.example.major.ewallet.service;

import com.example.major.ewallet.model.UserEntity;
import com.example.major.ewallet.repository.UserRepository;
import com.example.major.ewallet.request.CreateUserRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService {


    @Autowired
    UserRepository repository;

    @Autowired
    KafkaTemplate<String , String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private static final String USER_CREATED = "USER_CREATED";

    @SneakyThrows
    public UserEntity createUser(CreateUserRequestDto requestDto){
        UserEntity user = requestDto.toUser();
        UserEntity save = repository.save(user);
        log.info(" saved user {} ", user);

        /**
         * topup the wallet
         */

        log.info(" ------- sending message to kafka {} ", user);
        kafkaTemplate.send(USER_CREATED, objectMapper.writeValueAsString(save));
        return save;
    }

    @Cacheable("userCache")
    public UserEntity getUserById(Long userId){
        return repository.findById(userId).orElse(null);
    }


}
