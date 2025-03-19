package com.ticketsnap.service;


import com.ticketsnap.models.Booking;
import com.ticketsnap.models.ShowSeat;
import com.ticketsnap.models.ShowSeatStatus;
import com.ticketsnap.repository.BookingRepository;
import com.ticketsnap.repository.ShowSeatRepository;
import com.ticketsnap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Booking bookMovie(List<Long> showSeatIds, String email) {
        List<ShowSeat> seats = showSeatRepository.findAllById(showSeatIds);
        if (seats.stream().anyMatch(seat -> seat.getShowSeatStatus() != ShowSeatStatus.AVAILABLE)) {
            throw new RuntimeException("Some seats are not available");
        }
        seats.forEach(seat -> seat.setShowSeatStatus(ShowSeatStatus.OCCUPIED));
        showSeatRepository.saveAll(seats);

        Booking booking = Booking.builder()
                .showSeatList(seats)
                .show(seats.get(0).getShow())
                .amount(seats.size() * 100.0) // Example pricing
                .bookedAt(new Date())
                .user(userRepository.findByEmail(email).orElseThrow())
                .build();
        return bookingRepository.save(booking);
    }
}
