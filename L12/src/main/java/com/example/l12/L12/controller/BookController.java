package com.example.l12.L12.controller;

import com.example.l12.L12.models.Book;
import com.example.l12.L12.models.UserInfo;
import com.example.l12.L12.requests.CreateBookRequestDto;
import com.example.l12.L12.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class BookController {


    @Autowired
    BookService bookService;

    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> createAUser(@Valid @RequestBody CreateBookRequestDto book){
        log.info("Request Received {} " , book);
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }


    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> fetchAllUsers(){
        log.info("Request Received for fetching all books  ");
        return new ResponseEntity<>(bookService.fetchAllBooks(), HttpStatus.OK);
    }
}

