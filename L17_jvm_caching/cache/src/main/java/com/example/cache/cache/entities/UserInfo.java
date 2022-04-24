package com.example.cache.cache.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    String name;
    @Column(name = "email_id",  unique = true, columnDefinition = "varchar(30)")
    String email;

    String password;

    String userRoles;

    @CreationTimestamp
    LocalDateTime creationDate;

    @UpdateTimestamp
    LocalDateTime modifiedDate;



}
