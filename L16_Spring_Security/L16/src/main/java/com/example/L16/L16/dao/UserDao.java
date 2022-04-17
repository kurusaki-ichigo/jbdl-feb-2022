package com.example.L16.L16.dao;

import com.example.L16.L16.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserDao extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findByEmail(String email);

}
