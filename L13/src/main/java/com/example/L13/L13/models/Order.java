package com.example.L13.L13.models;


import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    @ManyToOne
    UserInfo userInfo;
}
