package com.major.ewallet.controller;

import com.major.ewallet.utils.ResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    ResponseGenerator responseGenerator;


    @PostMapping("/transaction")
    public ResponseEntity<String> createTransaction(@RequestParam(value = "senderId", defaultValue = "0") Long senderId,
                                                    @RequestParam(value = "receiverId", defaultValue = "0") Long receiverId,
                                                    @RequestParam(value = "amount", defaultValue = "0") Double amount) {
        return responseGenerator.generateSuccessResponse(transactionService.transferMoney(senderId, receiverId, amount),
                HttpStatus.CREATED);
    }

    @GetMapping("/transaction/status")
    public ResponseEntity<String> getTransactionStatus(@RequestParam(value = "transactionId", defaultValue = "") String transactionId) {
        return responseGenerator.generateSuccessResponse(transactionService.getTransactionStatus(transactionId),
                HttpStatus.OK);
    }


}
