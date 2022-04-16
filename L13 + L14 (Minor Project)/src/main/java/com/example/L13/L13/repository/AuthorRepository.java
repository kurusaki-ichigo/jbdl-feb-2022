package com.example.L13.L13.repository;

import com.example.L13.L13.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


    /**
     * Writing custom Queries using JPQL
     * select * from author where email = ?
     */

    Optional<Author> findByEmail(String email);

}
