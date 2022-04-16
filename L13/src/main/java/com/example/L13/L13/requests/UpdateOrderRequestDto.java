package com.example.L13.L13.requests;

import com.example.L13.L13.models.OrderStatus;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequestDto {

    @Positive
    double amount;

    @NotBlank
    String orderStatus;

    @NotBlank
    String orderReferenceId;


}
