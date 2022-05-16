package com.major.ewallet.response;


import com.major.ewallet.entity.WalletUpdateStatus;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WalletUpdateResponse implements Serializable {

    WalletUpdateStatus status;
    Long transactionId;

}
