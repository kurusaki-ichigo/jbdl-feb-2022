package com.example.L13.L13.repository;

import com.example.L13.L13.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {


    Optional<Book> findByIsbn(String isbn);
}
