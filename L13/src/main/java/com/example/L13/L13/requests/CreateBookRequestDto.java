package com.example.L13.L13.requests;

import com.example.L13.L13.models.Author;
import com.example.L13.L13.models.Book;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequestDto {

    @NotBlank
    String name;

    @Positive
    int cost;

    @NotBlank
    String isbn;


    @NotBlank
    String authorName;

    @NotBlank
    @Email
    String authorEmail;


    public Book toBook(){
        Author author = Author.builder()
                .name(authorName)
                .email(authorEmail).build();


        return Book.builder()
                .cost(cost)
                .isbn(isbn)
                .name(name)
                .author(author)
                .build();
    }
}
