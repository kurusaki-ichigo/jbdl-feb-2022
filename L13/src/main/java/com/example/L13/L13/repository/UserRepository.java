package com.example.L13.L13.repository;

import com.example.L13.L13.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
}
