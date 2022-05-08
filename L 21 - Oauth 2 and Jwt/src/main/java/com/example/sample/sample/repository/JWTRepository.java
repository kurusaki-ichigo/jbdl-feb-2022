package com.example.sample.sample.repository;

import com.example.sample.sample.entity.JWTClient;
import com.example.sample.sample.models.S2SClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JWTRepository extends JpaRepository<JWTClient, String> {


    Optional<JWTClient> findByClient(S2SClient client);

}
