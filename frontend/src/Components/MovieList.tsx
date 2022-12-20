import {Movie} from "./Movie";
import {useState} from "react";
import MovieCard from "./MovieCard";

export default function MovieList({movie} : {movie: Movie[]}) {
    const [search, setSearch] = useState("");

    return (
        <>
            <input type="search" placeholder={"Search Movies"} onChange={event => setSearch(event.target.value)}/>
            <ul className={"Container"}>{movie.filter(mov => mov.name.includes(search))
                .map(mov => (
                <MovieCard key={mov.id} {...mov} />
            ))}
            </ul>
        </>
    )
}