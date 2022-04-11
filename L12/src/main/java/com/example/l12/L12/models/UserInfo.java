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
 *
 *
 *  Multiple
 *      ----> @Transactional (JPA repository) -- we dont have to use
 *      --> we have multiple calls to db
 *          ---> we have to use
 *
 *
 *          Order -- state (IN_PROGRESS)
 *          book my show
 *
 * @Transactional vs @Transactional at each step
 *          {
 *                  --> hold ticket (blocked)
 *                      --> Place an order (pending state)
 *                          --> payment (pending)
 *                          --> payment (success)
 *                      ---> order is success
 *                 ---> marked assigned
 *              ---> tickets generated
 *              (way long process)
 *                      --> parsing certain data
 *                      ---> hitting apis of 3rd
 *           } catch (Exception){
 *
 *                  -- unblock ticket
 *                  -- mark order invalid
 *                  -- mark payment invalid
 *
 *           }
 *
 *
 *          ||
 *   ------------>  passport information (gov api) --> (definetly lag)
 *  Transactional --> connection.open()
 *
 *
 *
 *
 *
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
