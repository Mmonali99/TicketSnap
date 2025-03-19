package com.ticketsnap.dtos;


import lombok.Data;

@Data
public class PaymentRequestDto {
    private Long bookingId;
    private double amount;
}
