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
            <ul className={"Container"}>{props.movies.filter(mov => mov.name.toLowerCase().includes(search.toLowerCase()))
                .map(mov => (
                <MovieCard movie={mov} deleteMovie={props.deleteMovie} />
            ))}
            </ul>
        </>
    )
}