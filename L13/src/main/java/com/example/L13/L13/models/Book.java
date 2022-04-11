package com.example.L13.L13.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "my_book" , indexes = @Index(name = "uniqueISBN" , columnList = "isbn"))
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;

    String isbn;

    int cost;

    /**
     * JPA relations
     *  Unidirectional  keep things loosely coupled
     *  Bi directional--- keep things tightly coupled
     *
     */

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Author author;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private UserInfo user;


    @CreationTimestamp
    LocalDateTime creationDate;

    @UpdateTimestamp
    LocalDateTime modifiedDate;


}
