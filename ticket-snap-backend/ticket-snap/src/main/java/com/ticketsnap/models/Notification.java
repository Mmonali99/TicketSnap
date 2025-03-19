package com.ticketsnap.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Notification extends BaseModel {
    @ManyToOne
    private User user;
    private String message;
    @Enumerated(EnumType.STRING)
    private NotificationType type;
    private Date sentAt;

    public enum NotificationType {
        EMAIL, SMS
    }
}