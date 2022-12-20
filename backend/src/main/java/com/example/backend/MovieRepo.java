package com.example.backend;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class MovieRepo {

    List<Movie> movies = new ArrayList<>(
            List.of(
                    new Movie(1, "Die Verurteilten", 1994, "https://www.moviejones.de/facebook/bilder/filme/001/1476_p.jpg"),
                    new Movie(2, "Der Pate", 1972, "https://up.picr.de/38838835jo.jpg"),
                    new Movie(3, "The Dark Knight", 2008, "https://ae01.alicdn.com/kf/HTB1NqBBhJfJ8KJjy0Feq6xKEXXaU.jpg"),
                    new Movie(4, "Der Pate 2", 1974, "https://media.services.cinergy.ch/media/box1600/9df939a5498a23f83a877dbcb5c2976c9bd32559.jpg"),
                    new Movie(5, "Die zwölf Geschworenen", 1957, "https://image.film.at/images/cfs_1864w/5028324/wO931IxQ9cmBRJmQ7ZHjvRygaKH.jpg"),
                    new Movie(6, "Schindlers Liste", 1993, "https://buzz.tt/media/posters/2270/posters_3_1500.jpg"),
                    new Movie(7, "Der Herr der Ringe: Die Rückkehr des Königs", 2003, "https://static.kino.de/wp-content/gallery/der-herr-der-ringe-die-rueckkehr-des-koenigs-2003/herr-der-ringe-die-rckkehr-des-knigs-der-2-rcm0x1920u.jpg"),
                    new Movie(8, "Pulp Fiction", 1994, "https://cdn.shopify.com/s/files/1/1416/8662/products/pulp_fiction_1994_french_original_film_art_ab0be132-fe07-4c64-ba85-c2dd6d8e1349_5000x.jpg?v=1569193781"),
                    new Movie(9, "Der Herr der Ringe: Die Gefährten", 2001, "https://2.bp.blogspot.com/-gsprCoUZKf0/URDmQvM-xQI/AAAAAAAAAI8/MZXwH_kL1Ps/s1600/der_herr_der_ringe_-_die_gefaehrten.jpg"),
                    new Movie(10, "Zwei glorreiche Halunken", 1966, "https://image.tmdb.org/t/p/original/pdOqKAVXEtUZdN00mCq6V357X6k.jpg")
            )
    );

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(int id) {
        Movie movie = null;

        for (Movie m : movies) {
            if (m.getId() == id) {
                movie = m;
                break;
            }
        }
        return movie;
    }
}

