import React, {useEffect, useState} from 'react';
import './App.css';
import {Movie} from "./Components/Movie";
import axios from "axios";
import MovieList from "./Components/MovieList";
import AddMovie from "./Components/NewMovie";

function App() {
  const [movies, setMovies] = useState<Movie[]>([]);

  useEffect(() => {
    (async () => {
      const response = await axios.get("/movies")
      setMovies(response.data);
    })();
  }, []);

  const deleteMovies =  async (id: number) => {
    await axios.delete("/movies/"+id);
        setMovies(
            movies.filter((mov) => {
              return mov.id !== id;
            })
        )
  }

  return (
    <>
        {movies.length === 0 ?
            <p>Nothing to see here...</p> :
        <MovieList movies={movies} deleteMovie={deleteMovies}/>
        }
        <AddMovie/>
    </>
  );
}

export default App;
