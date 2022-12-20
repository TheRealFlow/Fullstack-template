import React, {useEffect, useState} from 'react';
import './App.css';
import {Movie} from "./Components/Movie";
import axios from "axios";
import MovieList from "./Components/MovieList";

function App() {
  const [movies, setMovies] = useState<Movie[]>([]);

  useEffect( () => {
    (async () => {
      const response = await axios.get("/api/movies")
      setMovies(response.data);
    })();
  }, [])

  return (
    <>
      <MovieList movie={movies}/>
    </>
  );
}

export default App;
