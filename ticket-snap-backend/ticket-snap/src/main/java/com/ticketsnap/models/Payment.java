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
public class Payment extends BaseModel {
    @ManyToOne
    private Booking booking;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private Date paymentDate;

    public enum PaymentStatus {
        PENDING, COMPLETED, FAILED
    }
}