import React, { useState, useEffect } from 'react';
import api from '../services/api';

const SeatSelector = ({ showId }) => {
  const [seats, setSeats] = useState([]);
  const [selectedSeats, setSelectedSeats] = useState([]);

  useEffect(() => {
    const fetchSeats = async () => {
      try {
        const response = await api.get(`/shows/${showId}/seats`); // Assume this endpoint exists
        setSeats(response.data);
      } catch (err) {
        console.error('Failed to fetch seats:', err);
      }
    };
    fetchSeats();
  }, [showId]);

  const handleSeatClick = (seatId) => {
    if (selectedSeats.includes(seatId)) {
      setSelectedSeats(selectedSeats.filter((id) => id !== seatId));
    } else {
      setSelectedSeats([...selectedSeats, seatId]);
    }
  };

  const handleBook = async () => {
    try {
      const response = await api.post('/ticket/book', { showSeatIds: selectedSeats });
      alert(`Booking confirmed! Booking ID: ${response.data.bookingId}`);
      setSelectedSeats([]);
    } catch (err) {
      alert('Booking failed');
    }
  };

  return (
    <div className="seat-selector">
      <h3>Select Seats</h3>
      <div className="seat-grid">
        {seats.map((seat) => (
          <button
            key={seat.id}
            className={`seat ${seat.showSeatStatus === 'OCCUPIED' ? 'occupied' : ''} ${
              selectedSeats.includes(seat.id) ? 'selected' : ''
            }`}
            disabled={seat.showSeatStatus === 'OCCUPIED'}
            onClick={() => handleSeatClick(seat.id)}
          >
            {seat.seat.number}
          </button>
        ))}
      </div>
      <button onClick={handleBook} disabled={selectedSeats.length === 0}>
        Book Selected Seats
      </button>
    </div>
  );
};

export default SeatSelector;