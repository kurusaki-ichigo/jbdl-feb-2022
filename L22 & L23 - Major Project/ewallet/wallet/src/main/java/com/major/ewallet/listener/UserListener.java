package com.major.ewallet.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.ewallet.entity.WalletEntity;
import com.major.ewallet.repository.WalletRepository;
import com.major.ewallet.request.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Service
@Slf4j
public class UserListener {

    private static final String USER_CREATED = "USER_CREATED";

    private static final String WALLET_CREATED = "WALLET_CREATED";

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = {USER_CREATED}, groupId = "wallet_group")
    public void walletCreation(ConsumerRecord<String, String> record) throws JsonProcessingException {
        log.info("------------> record received {} ", record);
        String message = record.value();
        User user = objectMapper.readValue(message, User.class);
        log.info(" user {} ", user);
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setUserId(user.getId());
        walletEntity.setBalance(Double.valueOf(0));
        walletEntity.setWalletId(UUID.randomUUID().toString());
        walletEntity.setWalletName("SAVINGS");
        WalletEntity save = walletRepository.save(walletEntity);
        log.info(" wallet created with info {} ", save);
        String messageToBeSent = objectMapper.writeValueAsString(save);
        log.info(" sending to kafka topic {} with message {}  ", WALLET_CREATED, messageToBeSent);
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(WALLET_CREATED, messageToBeSent);
        addCallback(messageToBeSent, send);
    }

    private void addCallback(String message, ListenableFuture<SendResult<String, String>> future) {
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[ " + message + "] due to : " + ex.getMessage() + " class :: " + ex.getClass().getSimpleName());
            }
        });
    }


}
