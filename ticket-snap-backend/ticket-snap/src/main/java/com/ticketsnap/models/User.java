package com.ticketsnap.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "ticketsnap_users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseModel {
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String roles; // Added for role-based access (e.g., "ROLE_USER,ROLE_ADMIN")

    // Constructor for setting ID (used in NotificationService)
    public User(Long id) {
        this.setId(id);
    }
}