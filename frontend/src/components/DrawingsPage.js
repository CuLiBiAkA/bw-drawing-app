// src/components/DrawingsPage.js
import React, { useState } from 'react';
import axios from 'axios';

function DrawingsPage() {
  const [drawingName, setDrawingName] = useState('');
  const [drawingDescription, setDrawingDescription] = useState('');

  const handleAddDrawing = (e) => {
    e.preventDefault();

    const newDrawing = {
      name: drawingName,
      description: drawingDescription,
    };

    axios.post('http://localhost:8080/drawings', newDrawing)
      .then(response => {
        alert('Drawing added successfully!');
        setDrawingName('');
        setDrawingDescription('');
      })
      .catch(error => {
        console.error('There was an error adding the drawing!', error);
      });
  };

  return (
    <div>
      <h1>Add New Drawing</h1>
      <form onSubmit={handleAddDrawing}>
        <div>
          <label>Name</label>
          <input
            type="text"
            value={drawingName}
            onChange={(e) => setDrawingName(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Description</label>
          <input
            type="text"
            value={drawingDescription}
            onChange={(e) => setDrawingDescription(e.target.value)}
            required
          />
        </div>
        <button type="submit">Add Drawing</button>
      </form>
    </div>
  );
}

export default DrawingsPage;