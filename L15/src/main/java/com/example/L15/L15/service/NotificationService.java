package com.example.L15.L15.service;

import com.example.L15.L15.entities.NotificationStatus;
import com.example.L15.L15.entities.embeddable.Notification;
import com.example.L15.L15.entities.embeddable.NotificationId;
import com.example.L15.L15.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class NotificationService implements InitializingBean {

    @Autowired
    NotificationRepository notificationRepository;

    String IdempotencyKey = "firstPartOfCompositeKey";
    String source = "secondPartOfCompositeKey";


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(" ----------------> Testing --------");
        Notification notification = new Notification();
        notification.setNotificationId(new NotificationId(IdempotencyKey, source));
        notification.setTemplateId("hey");
        notification.setTriggerTo(null);
        notification.setStatus(NotificationStatus.NOT_PICKED);
        notificationRepository.save(notification);
        /**
         * find the same using composite key
         */
        Optional<Notification> byId = notificationRepository.findById(new NotificationId(IdempotencyKey, source));
        if(byId.isEmpty()){
            log.error(" no data is present");
            return;
        }

        Notification persisted = byId.get();
        log.info(" found data {} ", persisted);

    }
}
