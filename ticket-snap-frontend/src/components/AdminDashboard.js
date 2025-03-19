import React, { useState } from 'react';
import api from '../services/api';

const AdminDashboard = () => {
  const [movie, setMovie] = useState({ name: '', language: '', rating: 0, duration: 0, category: '' });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.post('/admin/movies', movie);
      alert('Movie added successfully');
      setMovie({ name: '', language: '', rating: 0, duration: 0, category: '' });
    } catch (err) {
      alert('Failed to add movie');
    }
  };

  return (
    <div className="admin-dashboard">
      <h2>Admin Dashboard</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Movie Name"
          value={movie.name}
          onChange={(e) => setMovie({ ...movie, name: e.target.value })}
          required
        />
        <input
          type="text"
          placeholder="Language"
          value={movie.language}
          onChange={(e) => setMovie({ ...movie, language: e.target.value })}
          required
        />
        <input
          type="number"
          placeholder="Rating"
          value={movie.rating}
          onChange={(e) => setMovie({ ...movie, rating: parseFloat(e.target.value) })}
          required
        />
        <input
          type="number"
          placeholder="Duration (minutes)"
          value={movie.duration}
          onChange={(e) => setMovie({ ...movie, duration: parseInt(e.target.value) })}
          required
        />
        <input
          type="text"
          placeholder="Category"
          value={movie.category}
          onChange={(e) => setMovie({ ...movie, category: e.target.value })}
          required
        />
        <button type="submit">Add Movie</button>
      </form>
    </div>
  );
};

export default AdminDashboard;