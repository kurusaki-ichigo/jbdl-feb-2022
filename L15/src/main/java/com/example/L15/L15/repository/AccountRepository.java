package com.example.L15.L15.repository;

import com.example.L15.L15.entities.IdClass.Account;
import com.example.L15.L15.entities.IdClass.AccountId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, AccountId> {
}
