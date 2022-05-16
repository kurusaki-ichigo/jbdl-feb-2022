package com.major.ewallet.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.ewallet.model.LedgerEntity;
import com.major.ewallet.model.TransactionStatus;
import com.major.ewallet.repository.LedgerRepository;
import com.major.ewallet.requests.WalletUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class WalletUpdateListener {

    private static final String WALLET_UPDATED = "WALLET_UPDATED";

    private static final String TRANSACTION_CLOSURE = "TRANSACTION_CLOSURE";

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    LedgerRepository ledgerRepository;

    @Autowired
    KafkaTemplate<String , String> kafkaTemplate;

    @KafkaListener(topics = {WALLET_UPDATED}, groupId = "transaction_group")
    public void walletCreation(ConsumerRecord<String, String> record) throws JsonProcessingException {
        String message = record.value();
        log.info(" message received {}  for record {} ", message, record);
        WalletUpdateRequest walletRequest = objectMapper.readValue(message, WalletUpdateRequest.class);
        log.info(" user {} ", walletRequest);
        /**
         * Create a transaction in pending state
         *
         */

        Optional<LedgerEntity> byId = ledgerRepository.findById(walletRequest.getTransactionId());
        if (byId.isEmpty()) {
            log.error(" No matching transaction found ");
            return;
        }

        LedgerEntity transaction = byId.get();
        transaction.setTransactionStatus(TransactionStatus.FAILURE);
        if ("SUCCESS".equalsIgnoreCase(walletRequest.getStatus())) {
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        }
        ledgerRepository.save(transaction);
        log.info(" transaction {} ", transaction);
        log.info(" sending message to topic {} ", TRANSACTION_CLOSURE);
        kafkaTemplate.send(TRANSACTION_CLOSURE, objectMapper.writeValueAsString(transaction));
    }


}
