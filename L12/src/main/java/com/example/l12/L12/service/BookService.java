package com.example.l12.L12.service;

import com.example.l12.L12.models.Book;
import com.example.l12.L12.repository.BookRepository;
import com.example.l12.L12.requests.CreateBookRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book createBook(CreateBookRequestDto userRequestDto) {
        Book  book = userRequestDto.toBook();
        bookRepository.save(book);
        Integer id = book.getId();
        Optional<Book> byId = bookRepository.findById(id);
        return byId.get();
    }

    public List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }

}
