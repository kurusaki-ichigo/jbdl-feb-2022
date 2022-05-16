package com.major.ewallet.utils;

import com.major.ewallet.model.LedgerEntity;
import com.major.ewallet.model.TransactionStatus;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class LedgerUtility {

    public static LedgerEntity generatePendingTransactionForSenderAndReceiverId(Long senderId, Long receiverId) {
        LedgerEntity transaction = new LedgerEntity();
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setSenderId(senderId);
        transaction.setReceivedId(receiverId);
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        return transaction;
    }
}
