package com.ticketsnap.controllers;

import com.ticketsnap.dtos.BookTicketRequestDto;
import com.ticketsnap.dtos.BookTicketResponseDto;
import com.ticketsnap.models.Booking;
import com.ticketsnap.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final BookingService bookingService;

    @Autowired
    public TicketController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody BookTicketResponseDto bookTicket(
            @RequestBody BookTicketRequestDto requestDto, Authentication authentication) {
        System.out.println(requestDto);
        Booking booking = bookingService.bookMovie(requestDto.getShowSeatIds(), authentication.getName());
        return BookTicketResponseDto.builder()
                .bookingId(booking.getId())
                .amount(booking.getAmount())
                .seatNumbers(booking.getShowSeatList().stream().map(showSeat -> showSeat.getId()).collect(Collectors.toList()))
                .theatreName(booking.getShow().getScreen().getTheatre().getName())
                .build();
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public String getTicket() {
        System.out.println("Request hits the server - 2");
        return "Get the ticket for you, world!";
    }
}
