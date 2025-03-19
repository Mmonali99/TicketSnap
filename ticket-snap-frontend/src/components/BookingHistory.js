import React, { useState, useEffect } from 'react';
import api from '../services/api';

const BookingHistory = () => {
  const [bookings, setBookings] = useState([]);

  useEffect(() => {
    const fetchBookings = async () => {
      try {
        const response = await api.get('/user/bookings'); // Assume this endpoint exists
        setBookings(response.data);
      } catch (err) {
        console.error('Failed to fetch bookings:', err);
      }
    };
    fetchBookings();
  }, []);

  return (
    <div className="booking-history">
      <h2>Booking History</h2>
      <ul>
        {bookings.map((booking) => (
          <li key={booking.id}>
            Booking ID: {booking.id} | Movie: {booking.show.movie.name} | Amount: ${booking.amount}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookingHistory;