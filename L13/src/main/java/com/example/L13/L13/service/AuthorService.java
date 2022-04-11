package com.example.L13.L13.service;

import com.example.L13.L13.models.Author;
import com.example.L13.L13.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;



    public Author saveOrUpdate(Author author){
        return authorRepository.save(author);
    }


    public Optional<Author> findByEmail(Author author){
        return authorRepository.findByEmail(author.getEmail());
    }






}
