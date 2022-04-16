package com.example.L13.L13.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    @Column(name = "email_id",  columnDefinition = "varchar(30)")
    String email;
    String address;
    Integer phoneNumber;


    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @JsonIgnore
    List<Book> issuedBooks;



    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @JsonIgnore
    List<Orders> ordersList;



    @CreationTimestamp
    LocalDateTime creationDate;

    @UpdateTimestamp
    LocalDateTime modifiedDate;


}
