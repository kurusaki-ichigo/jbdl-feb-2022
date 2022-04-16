package com.example.L15.L15.entities.embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

/*
 * these need to be mandatory
 *  -> Serializable
 *  -> EqualsAndHashCode (override equals and hashCode)
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
@ToString
public class NotificationId implements Serializable {
    private static final long serialVersionUID = 5391096286964360626L;

    String idempotencyKey;
    String source;
}
