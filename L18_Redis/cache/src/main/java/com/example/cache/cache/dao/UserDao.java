package com.example.cache.cache.dao;


import com.example.cache.cache.entities.UserInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserDao extends JpaRepository<UserInfo, Long> {

//    @Cacheable(cacheNames = "userCache")
    Optional<UserInfo> findByEmail(String email);

}
