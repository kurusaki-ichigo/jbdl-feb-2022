package com.example.L15.L15.repository;

import com.example.L15.L15.entities.embeddable.Notification;
import com.example.L15.L15.entities.embeddable.NotificationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, NotificationId> {
}
