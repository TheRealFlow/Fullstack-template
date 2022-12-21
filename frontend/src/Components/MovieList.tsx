import {Movie} from "./Movie";
import {useState} from "react";
import MovieCard from "./MovieCard";

type MovieList = {
    movies: Movie[],
    deleteMovie: (id: number) => void
}

export default function MovieList(props: MovieList) {
    const [search, setSearch] = useState("");

    return (
        <>
            <input type="search" placeholder={"Search Movies"} onChange={event => setSearch(event.target.value)}/>
            <button>Add a new Movie</button>
            <ul className={"Container"}>{props.movies.filter(mov => mov.name.includes(search))
                .map(mov => (
                <MovieCard movie={mov} deleteMovie={props.deleteMovie} />
            ))}
            </ul>
        </>
    )
}