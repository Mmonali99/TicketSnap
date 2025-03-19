package com.ticketsnap.controllers;


import com.ticketsnap.dtos.PaymentRequestDto;
import com.ticketsnap.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    @ResponseStatus(HttpStatus.OK)
    public String processPayment(@RequestBody PaymentRequestDto request) {
        return paymentService.processPayment(request.getBookingId(), request.getAmount());
    }
}
