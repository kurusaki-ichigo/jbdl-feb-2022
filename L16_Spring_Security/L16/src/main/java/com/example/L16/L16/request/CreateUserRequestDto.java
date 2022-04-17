package com.example.L16.L16.request;

import com.example.L16.L16.entities.UserInfo;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
