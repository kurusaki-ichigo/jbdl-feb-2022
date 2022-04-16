package com.example.L15.L15.entities;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Slf4j
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer bookId;

    @Column
    String name;

    String isbn;

    int cost;

    @Enumerated(value = EnumType.STRING)
    BookStatus bookStatus;

    /**
     * JPA relations
     *  Unidirectional  keep things loosely coupled
     *  Bi directional--- keep things tightly coupled
     *
     */

    @ManyToMany(mappedBy = "booksLiked")
    Set<UserInfo> likedByUsers;

    @CreationTimestamp
    LocalDateTime creationDate;

    @UpdateTimestamp
    LocalDateTime modifiedDate;


    /**
     * @Audited which listens to events that are being generate when update happens to an entity
     * -- @Prepersist
     * {@link  PreUpdate}
     *
     */
    @PrePersist
    public void prePersistCheck(){
        log.info("--------> pre persist check {} ", this.bookStatus);
        if(Objects.isNull(this.bookStatus)){
            this.bookStatus = BookStatus.AVAILABLE;
        }
    }


}
