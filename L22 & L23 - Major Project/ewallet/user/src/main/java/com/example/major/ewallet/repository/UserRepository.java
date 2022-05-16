package com.example.major.ewallet.repository;


import com.example.major.ewallet.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
