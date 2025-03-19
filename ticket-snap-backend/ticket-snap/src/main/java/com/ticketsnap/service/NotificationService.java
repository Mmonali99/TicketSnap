package com.ticketsnap.service;

import com.ticketsnap.models.Notification;
import com.ticketsnap.models.Notification.NotificationType; // Import enum
import com.ticketsnap.models.User;
import com.ticketsnap.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(Long userId, String message, NotificationType type) {
        Notification notification = new Notification();
        notification.setUser(new User(userId)); // Assuming constructor sets ID
        notification.setMessage(message);
        notification.setType(type);
        notification.setSentAt(new Date());
        notificationRepository.save(notification);
    }
}