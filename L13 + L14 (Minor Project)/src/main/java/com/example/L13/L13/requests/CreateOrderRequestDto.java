package com.example.L13.L13.requests;

import com.example.L13.L13.models.Orders;
import com.example.L13.L13.models.OrderStatus;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.UUID;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequestDto {

    @Positive
    double amount;

    @NotBlank
    String orderStatus;

    public Orders toOrder(){
        return Orders.builder()
                .amount(amount)
                .orderReference(UUID.randomUUID().toString())
                .orderStatus(OrderStatus.valueOf(orderStatus))
                .build();
    }
}
