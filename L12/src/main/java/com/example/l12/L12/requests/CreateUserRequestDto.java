package com.example.l12.L12.requests;


import com.example.l12.L12.models.UserInfo;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 *
 *  --> request {@link  CreateUserRequestDto}
 *      mapstruct
 *      Lombook builder
 *  --> entity {@link  UserInfo}
 *
 */



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
