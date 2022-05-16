package com.major.ewallet.repository;

import com.major.ewallet.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {

    WalletEntity findByUserId(Long userId);
}
