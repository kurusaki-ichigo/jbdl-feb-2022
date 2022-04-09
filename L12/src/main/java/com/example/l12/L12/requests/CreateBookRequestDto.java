package com.example.l12.L12.requests;

import com.example.l12.L12.models.Book;
import lombok.*;

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



    public Book toBook(){
        return Book.builder()
                .cost(cost)
                .name(name)
                .build();
    }
}
