package com.example.L11.L11.model.enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {


    @JsonIgnore
    Integer id;

    @NonNull
    String name;

    String email;

    String address;

    /**
     * later why integer -- when we will cover mysql/ database
     * int vs varchar -- huge performance difference (index)
     */
    Integer phoneNumber = 83283828;


    /**
     * Getter / settter
     * Constructor
     * Reflection
     */

    public void display() {
        System.out.println(this);
    }
}
