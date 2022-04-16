package com.example.L15.L15.entities.embeddable;


import com.example.L15.L15.entities.NotificationStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Entity

/**
 *      {
 *          "idempotency_key" : (transactionId) --> Can I have this column as primary key --? (Yes  , No )
 *          "source" -- userService / transactionService  ---> Can I use this make something usefule -->Yes
 *          "template_id" -- template_1 / template_2
 *          "dynamic fields" : {json}
 *          "to" : "userId"
 *          "status" : "SENT / IN_PROGRESS | NOT_PICKED | FAILED"
 *          "created_at"
 *          "updated_at"
 *      }
 * */
public class Notification {

    @EmbeddedId
    NotificationId notificationId;

    String templateId;
    String dynamicFields;
    /**
     * this would have userId
     */
    String triggerTo;

    @Enumerated(value = EnumType.STRING)
    NotificationStatus status;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;
}
