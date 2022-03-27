package com.example.l8.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.UUID;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    @Setter(AccessLevel.NONE)
    String id = UUID.randomUUID().toString();

    @NonNull String name;

    String email;

    String address;

    /**
     * later why integer -- when we will cover mysql/ database
     * int vs varchar -- huge performance difference (index)
     */
    Integer phoneNumber = 83283828;


    /**
     *  Getter / settter
     *  Constructor
     *  Reflection
     */

    public void display(){
        System.out.println(this);
    }
}
