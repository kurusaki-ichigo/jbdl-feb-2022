package com.major.ewallet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.ewallet.model.LedgerEntity;
import com.major.ewallet.repository.LedgerRepository;
import com.major.ewallet.utils.LedgerUtility;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class TransactionService {

    private static final String TRANSACTION_CREATION = "TRANSACTION_CREATION";

    @Autowired
    LedgerRepository ledgerRepository;

    @Autowired
    KafkaTemplate<String , String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;


    @SneakyThrows
    public LedgerEntity transferMoney(Long senderId , Long receiverId, Double amount){
        LedgerEntity transaction = LedgerUtility.generatePendingTransactionForSenderAndReceiverId(senderId, receiverId);
        transaction.setAmount(amount);
        ledgerRepository.save(transaction);
        log.info(" transaction {} ", transaction);
        log.info(" sending message to topic {} ", TRANSACTION_CREATION);
        kafkaTemplate.send(TRANSACTION_CREATION, objectMapper.writeValueAsString(transaction));
        return transaction;
    }


    public LedgerEntity getTransactionStatus(String transactionId){
       return ledgerRepository.findByTransactionId(transactionId);
    }


}
