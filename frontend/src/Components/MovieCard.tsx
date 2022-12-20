import {Movie} from "./Movie";
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Detail from "./DetailPage";

export default function MovieCard({id, name, year, imgURL} : Movie) {
    return (
        <BrowserRouter>
            <section className={"Card"}>
                <Link to={"/api/movies/"+id} state={{mov: name, year, imgURL}}>{name}</Link>
                <img className={"image"} src={imgURL}/>
                <p>{year}</p>
            </section>

            <Routes>
                <Route path={"/api/movies/:id"} element={<Detail/>}/>
            </Routes>
        </BrowserRouter>
    )
}