import {Movie} from "./Movie";
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Detail from "./DetailPage";

type MovieCard = {
    movie: Movie,
    deleteMovie: (id: number) => void
}

export default function MovieCard(props: MovieCard) {

    return (
        <BrowserRouter>
            <section className={"Card"}>
                <Link to={"/movies/"+props.movie.id} state={{mov: props.movie.name}}>{props.movie.name}</Link>
                <img className={"image"} src={props.movie.imgURL}/>
                <p>{props.movie.year}</p>
                <button onClick={() => props.deleteMovie(props.movie.id)}>Delete Movie</button>
            </section>

            <Routes>
                <Route path={"/movies/:id"} element={<Detail/>}/>
            </Routes>
        </BrowserRouter>
    )
}