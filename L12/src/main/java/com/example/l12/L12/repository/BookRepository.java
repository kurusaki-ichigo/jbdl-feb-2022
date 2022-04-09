package com.example.l12.L12.repository;

import com.example.l12.L12.models.Book;
import com.example.l12.L12.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
