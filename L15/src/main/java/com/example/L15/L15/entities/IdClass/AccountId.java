package com.example.L15.L15.entities.IdClass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AccountId implements Serializable {

    private static final long serialVersionUID = 53910962864360626L;

    String idempotencyKey;
    String source;

}
