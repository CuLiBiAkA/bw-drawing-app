// src/components/HomePage.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function HomePage() {
  const [drawings, setDrawings] = useState([]);

  useEffect(() => {
    // Получаем список рисунков с API
    axios.get('http://localhost:8080/drawings') // Убедитесь, что API доступно
      .then(response => {
        setDrawings(response.data);
      })
      .catch(error => {
        console.error('Error fetching drawings:', error);
      });
  }, []);

  return (
    <div>
      <h1>Welcome to the Drawing App</h1>
      <h2>Drawings List</h2>
      <ul>
        {drawings.map((drawing) => (
          <li key={drawing.id}>{drawing.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default HomePage;