package com.ticketsnap.service;

import com.ticketsnap.exceptions.PaymentFailedException;
import com.ticketsnap.models.Booking;
import com.ticketsnap.models.Payment;
import com.ticketsnap.models.Payment.PaymentStatus; // Import enum
import com.ticketsnap.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public String processPayment(Long bookingId, double amount) {
        // Simulate payment gateway integration (e.g., Stripe)
        Payment payment = new Payment();
        payment.setBooking(new Booking(bookingId)); // Constructor sets ID
        payment.setAmount(amount);
        payment.setStatus(PaymentStatus.COMPLETED); // Correct enum reference
        payment.setPaymentDate(new Date());
        paymentRepository.save(payment);
        return "Payment successful";
    }
}