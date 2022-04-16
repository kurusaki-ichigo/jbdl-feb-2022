package com.example.L15.L15.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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
    Integer userId;
    String name;
    @Column(name = "email_id",  columnDefinition = "varchar(30)")
    String email;
    String address;
    Integer phoneNumber;

    /**
     * way one
     */
    @ManyToMany
    @JoinTable(name = "wish_list",
            joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    Set<Book> booksLiked;

    /**
     * OneToMany
     */
    @OneToMany(mappedBy = "userInfo")
    Set<CourseRating> ratings;



    @CreationTimestamp
    LocalDateTime creationDate;

    @UpdateTimestamp
    LocalDateTime modifiedDate;


}
