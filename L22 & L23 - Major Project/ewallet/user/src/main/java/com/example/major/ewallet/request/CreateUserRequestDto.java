package com.example.major.ewallet.request;

import com.example.major.ewallet.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDto {


    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String name;

    private String contactNumber;


    public UserEntity toUser(){
        return UserEntity.builder()
                .contactNumber(contactNumber)
                .email(email)
                .name(name)
                .build();
    }
}
