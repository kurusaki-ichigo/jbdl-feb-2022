package com.major.ewallet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private Long id;
    private Long senderId;
    private Long receivedId;
    private Double amount;
    private String transactionStatus;

}
