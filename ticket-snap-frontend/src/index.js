import React from 'react';
import { createRoot } from 'react-dom/client'; // Updated import
import App from './App';
import './styles/App.css';

const container = document.getElementById('root');
const root = createRoot(container); // Create a root
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);