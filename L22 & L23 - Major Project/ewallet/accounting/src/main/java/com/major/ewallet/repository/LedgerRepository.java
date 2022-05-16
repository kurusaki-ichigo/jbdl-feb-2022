package com.major.ewallet.repository;

import com.major.ewallet.model.LedgerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedgerRepository extends JpaRepository<LedgerEntity, Long> {


    LedgerEntity findByTransactionId(String transactionId);
}
