package com.example.L13.L13.service;

import com.example.L13.L13.exceptions.BookExistsException;
import com.example.L13.L13.exceptions.ConnectionErrorException;
import com.example.L13.L13.models.Author;
import com.example.L13.L13.models.Book;
import com.example.L13.L13.repository.BookRepository;
import com.example.L13.L13.requests.CreateBookRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;


    public Book createBook(CreateBookRequestDto userRequestDto) {
        Book  book = userRequestDto.toBook();

        Optional<Book> exisitingBook = bookRepository.findByIsbn(book.getIsbn());
        if(exisitingBook.isPresent()){
            throw new BookExistsException();
        }

        /**
         * create a new author is exisiting not present
         */
        try {
            Optional<Author> existingAuthor = authorService.findByEmail(book.getAuthor());
            if(existingAuthor.isEmpty()) {
                Author author = authorService.saveOrUpdate(book.getAuthor());
                book.setAuthor(author);
            } else {
                book.setAuthor(existingAuthor.get());
            }
        } catch (Exception e){
            throw new ConnectionErrorException();
        }

        return saveOrUpdate(book);
    }


    public Book saveOrUpdate(Book book){
      return bookRepository.save(book);
    }

    public List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }

}
