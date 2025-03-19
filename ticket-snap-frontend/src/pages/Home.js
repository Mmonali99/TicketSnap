import React from 'react';
import MovieList from '../components/MovieList';
import { logout } from '../services/auth';
import { useNavigate } from 'react-router-dom';

const Home = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  return (
    <div className="home">
      <h1>Welcome to TicketSnap</h1>
      <button onClick={handleLogout}>Logout</button>
      <MovieList />
    </div>
  );
};

export default Home;