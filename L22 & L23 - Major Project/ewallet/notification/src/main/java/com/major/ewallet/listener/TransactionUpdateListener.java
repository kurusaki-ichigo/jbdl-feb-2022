package com.major.ewallet.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.ewallet.model.Transaction;
import com.major.ewallet.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TransactionUpdateListener {

    private static final String TRANSACTION_CLOSURE = "TRANSACTION_CLOSURE";

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JavaMailSender emailSender;

    @Autowired
    RestTemplate restTemplate;

    @Value("${system.user.id}")
    private Long systemId;

    @KafkaListener(topics = {TRANSACTION_CLOSURE}, groupId = "notification_group")
    public void userCreation(String transactionInfo) throws JsonProcessingException {
        log.info(" ----------- message received {}  ", transactionInfo);
        Transaction transaction = objectMapper.readValue(transactionInfo, Transaction.class);
//        FAILURE,
//                SUCCESS

        User sender = restTemplate.getForObject("http://localhost:8080/user?id=" + transaction.getSenderId(), User.class);


        if(isSenderNotSystem(transaction) &&
                "FAILURE".equalsIgnoreCase(transaction.getTransactionStatus())){
            SimpleMailMessage senderMessage = new SimpleMailMessage();
            senderMessage.setFrom("ewallet.notify.app@gmail.com");
            senderMessage.setTo(sender.getEmail());
            senderMessage.setSubject("Transaction Declined");
            senderMessage.setText(" Hey .. your transaction has been declined ");
            emailSender.send(senderMessage);
        }

        if("SUCCESS".equalsIgnoreCase(transaction.getTransactionStatus())){

            if(isSenderNotSystem(transaction)){
                SimpleMailMessage senderMessage = new SimpleMailMessage();
                senderMessage.setFrom("ewallet.notify.app@gmail.com");
                senderMessage.setTo(sender.getEmail());
                senderMessage.setSubject("Transaction Success");
                senderMessage.setText(" Hey .. your transaction has been successful and " + transaction.getAmount() + "" +
                        "has been debited from your account");
                emailSender.send(senderMessage);
            }


            User receiver = restTemplate.getForObject("http://localhost:8080/user?id=" + transaction.getReceivedId(), User.class);
            SimpleMailMessage receiverMessage = new SimpleMailMessage();
            receiverMessage.setFrom("ewallet.notify.app@gmail.com");
            receiverMessage.setTo(receiver.getEmail());
            receiverMessage.setSubject("Transaction Declined");
            receiverMessage.setSubject("Transaction Success");
            receiverMessage.setText(" Hey .. your transaction has been successful and " + transaction.getAmount() + "" +
                    "has been credited to your account");
            emailSender.send(receiverMessage);
        }

        log.info(" user received {} ", transaction);

    }

    boolean isSenderNotSystem(Transaction transaction){
       return  !systemId.equals(transaction.getSenderId());
    }
}
