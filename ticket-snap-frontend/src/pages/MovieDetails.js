import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import api from '../services/api';
import SeatSelector from '../components/SeatSelector';

const MovieDetails = () => {
  const { id } = useParams();
  const [movie, setMovie] = useState(null);
  const [shows, setShows] = useState([]);
  const [selectedShow, setSelectedShow] = useState(null);

  useEffect(() => {
    const fetchMovie = async () => {
      try {
        const response = await api.get(`/movies/${id}`); // Assume this endpoint exists
        setMovie(response.data);
        const showsResponse = await api.get(`/movies/${id}/shows`); // Assume this endpoint exists
        setShows(showsResponse.data);
      } catch (err) {
        console.error('Failed to fetch movie details:', err);
      }
    };
    fetchMovie();
  }, [id]);

  if (!movie) return <div>Loading...</div>;

  return (
    <div className="movie-details">
      <h2>{movie.name}</h2>
      <p>Language: {movie.language}</p>
      <p>Rating: {movie.rating}</p>
      <p>Duration: {movie.duration} minutes</p>
      <p>Category: {movie.category}</p>
      <h3>Available Shows</h3>
      <ul>
        {shows.map((show) => (
          <li key={show.id} onClick={() => setSelectedShow(show.id)}>
            {show.startTime} at {show.screen.theatre.name}
          </li>
        ))}
      </ul>
      {selectedShow && <SeatSelector showId={selectedShow} />}
    </div>
  );
};

export default MovieDetails;