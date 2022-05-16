package com.example.major.ewallet.repository;

import com.example.major.ewallet.model.JWTClient;
import com.example.major.ewallet.model.S2SClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JWTRepository extends JpaRepository<JWTClient, String> {

    Optional<JWTClient> findByClient(S2SClient client);

}
