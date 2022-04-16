package com.example.L15.L15.service;

import com.example.L15.L15.entities.IdClass.Account;
import com.example.L15.L15.entities.IdClass.AccountId;
import com.example.L15.L15.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AccountService implements InitializingBean {


    @Autowired
    AccountRepository accountRepository;
    String IdempotencyKey = "firstPartOfCompositeKey";
    String source = "secondPartOfCompositeKey";

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info(" TEsting account with IDClass");
        Account account = Account.builder()
                .source(source)
                .idempotencyKey(IdempotencyKey).build();

        accountRepository.save(account);
        log.info("persited data");

        Optional<Account> byId = accountRepository.findById(new AccountId(IdempotencyKey, source));
        if(byId.isEmpty()){
            log.error(" not found ");
            return;
        }
        Account persistedData = byId.get();
        log.info(" persisted data -- {} ", persistedData);

        log.info("end");


    }
}
