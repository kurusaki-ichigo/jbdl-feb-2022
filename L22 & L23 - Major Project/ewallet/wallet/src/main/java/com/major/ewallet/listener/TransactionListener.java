package com.major.ewallet.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.ewallet.entity.WalletEntity;
import com.major.ewallet.entity.WalletUpdateStatus;
import com.major.ewallet.repository.WalletRepository;
import com.major.ewallet.request.Transaction;
import com.major.ewallet.request.User;
import com.major.ewallet.response.WalletUpdateResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class TransactionListener {

    private static final String TRANSACTION_CREATION = "TRANSACTION_CREATION";
    private static final String WALLET_UPDATED = "WALLET_UPDATED";


    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WalletRepository walletRepository;

    @Value("${system.user.id}")
    private Long systemId;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;



    @KafkaListener(topics = {TRANSACTION_CREATION}, groupId = "wallet_group")
    public void walletCreation(ConsumerRecord<String, String> record) throws JsonProcessingException {
        log.info(" record received {} ", record);
        String message = record.value();
        Transaction transaction = objectMapper.readValue(message, Transaction.class);
        log.info(" transaction {} ", transaction);

        /**
         * top up receiver wallet
         *
         * spend from sender wallet
         */
        WalletUpdateResponse walletUpdateResponse = new WalletUpdateResponse();
        walletUpdateResponse.setTransactionId(transaction.getId());
        try {
            if(transaction.getSenderId() != systemId){
                WalletEntity senderWallet = walletRepository.findByUserId(transaction.getSenderId());
                /**
                 * insufficient balance
                 */
                if(senderWallet.getBalance() < transaction.getAmount()){
                    throw new RuntimeException(" insufficient balance");
                }

                senderWallet.setBalance(Double.sum(senderWallet.getBalance() , -1 * transaction.getAmount()));
                walletRepository.save(senderWallet);
            }

            WalletEntity receiverWallet = walletRepository.findByUserId(transaction.getReceivedId());
            receiverWallet.setBalance(Double.sum(receiverWallet.getBalance() , transaction.getAmount()));
            walletRepository.save(receiverWallet);
            walletUpdateResponse.setStatus(WalletUpdateStatus.SUCCESS);
        } catch (Exception exception){
            log.error(" insufficient balance");
            walletUpdateResponse.setStatus(WalletUpdateStatus.FAILURE);
        }


        log.info(" wallet response  {} ", walletUpdateResponse);
        log.info(" sending to kafka message {} ", WALLET_UPDATED);
        kafkaTemplate.send(WALLET_UPDATED, objectMapper.writeValueAsString(walletUpdateResponse));
    }
}
