package com.example.L11.L11.model.requests;


import com.example.L11.L11.model.enities.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDto {

    @NotBlank
    String name;

    @Email
    String email;

    @NotBlank
    String address;

    /**
     * later why integer -- when we will cover mysql/ database
     * int vs varchar -- huge performance difference (index)
     */
    @NotNull
    Integer phoneNumber;


    /**
     *  Mapstruct
     *  (one of the)
     *
     * @return
     */
    public UserInfo toUser(){
        return UserInfo.builder()
                .address(this.address)
                .email(this.email)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .build();
    }

}
