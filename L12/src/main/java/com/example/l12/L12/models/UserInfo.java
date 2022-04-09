package com.example.l12.L12.models;

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
/**
 * Spring boot identified any class as bean
 * @Component (directly or indirectly)
 *
 * Hibernate does
 *  --- Identifyign
 * @Entity
 *
 *
 *
 *  Library
 *      (Minor Project 1)
 *
 *  Parking Lot
 *      (Minor Project 2)
 *
 */

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

    @CreationTimestamp
    LocalDateTime creationDate;

    @UpdateTimestamp
    LocalDateTime modifiedDate;


}
