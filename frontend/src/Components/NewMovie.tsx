import React, {useState} from "react";
import axios from "axios";
import {NewMovie} from "./Movie";

export default function AddMovie() {

    const [newMovie, setNewMovie] = useState<NewMovie>({title: "", imageURL: "", year: 0});

    function onChange(event: React.ChangeEvent<HTMLInputElement>) {
        const targetValue: string = event.target.value;
        const targetName: string = event.target.name;

        setNewMovie({...newMovie, [targetName]: targetValue});
    }

    async function onSubmit() {
        await axios.post("/api/movies", newMovie);
    }

    return (
        <>
            <form onSubmit={onSubmit}>
            <h2>Add a new Movie</h2>
                <section>
                    <input id={"title"}
                           type="text"
                           name={"title"}
                           value={newMovie.title}
                           onChange={onChange}
                           placeholder={"Title"}
                           required/>
                </section>
                <section>
                    <input id={"image"}
                           type="text"
                           name={"imageURL"}
                           value={newMovie.imageURL}
                           onChange={onChange}
                           placeholder={"Image URL"}
                           required/>
                </section>
                <section>
                    <input id={"year"}
                           type="number"
                           name={"year"}
                           value={newMovie.year}
                           onChange={onChange}
                           placeholder={"Release Year"}
                           required/>
                </section>
                <button type={"submit"}>Add Movie</button>
            </form>
        </>
    )
}
