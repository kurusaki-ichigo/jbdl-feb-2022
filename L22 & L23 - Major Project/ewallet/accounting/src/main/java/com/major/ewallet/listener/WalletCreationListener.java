package com.major.ewallet.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.ewallet.model.LedgerEntity;
import com.major.ewallet.model.TransactionStatus;
import com.major.ewallet.repository.LedgerRepository;
import com.major.ewallet.requests.WalletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.major.ewallet.utils.LedgerUtility.generatePendingTransactionForSenderAndReceiverId;

@Service
@Slf4j
public class WalletCreationListener {

    private static final String WALLET_CREATED = "WALLET_CREATED";

    private static final String TRANSACTION_CREATION = "TRANSACTION_CREATION";


    @Autowired
    LedgerRepository repository;

    @Autowired
    KafkaTemplate<String , String> kafkaTemplate;


    @Autowired
    ObjectMapper objectMapper;

    @Value("${system.user.id}")
    private Long systemId;


    @Value("${wallet.promo.balance}")
    private Double promoAmount;


    @KafkaListener(topics = {WALLET_CREATED}, groupId = "transaction_group")
    public void walletCreation(ConsumerRecord<String, String> record) throws JsonProcessingException {
        String message = record.value();
        log.info(" message received {}  for record {} ", message, record);
        WalletRequest walletRequest = objectMapper.readValue(message, WalletRequest.class);
        log.info(" user {} ", walletRequest);
        /**
         * Create a transaction in pending state
         *
         */
        LedgerEntity pendingTransaction = generatePendingTransactionForSenderAndReceiverId(systemId,
                walletRequest.getUserId());
        pendingTransaction.setAmount(promoAmount);
        LedgerEntity transaction = repository.save(pendingTransaction);
        log.info(" transaction {} ", transaction);
        log.info(" sending message to topic {} ", TRANSACTION_CREATION);
        kafkaTemplate.send(TRANSACTION_CREATION, objectMapper.writeValueAsString(transaction));
    }




}
