package com.example.cache.cache.request;

import com.example.cache.cache.entities.UserInfo;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

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
    String password;


    Boolean isMerchant;
    Boolean isCustomer;




    /**
     *  Mapstruct
     *  (one of the)
     *
     * @return
     */
    public UserInfo toUser(){
        return UserInfo.builder()
                .email(this.email)
                .name(this.name)
                .userRoles(userRoles())
                .password(this.password)
                .build();
    }


    private String userRoles(){
        if(Objects.nonNull(this.isMerchant) && this.isMerchant)
            return "MERCHANT";
        if(Objects.nonNull(this.isCustomer) && this.isCustomer)
            return "CUSTOMER";
        return "ANONYMOUS";
    }
}
