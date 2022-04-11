package com.example.L13.L13.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    String email;

    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    @JsonIgnore
    List<Book> bookList;


    @CreationTimestamp
    LocalDateTime creationDate;

    @UpdateTimestamp
    LocalDateTime modifiedDate;

}
