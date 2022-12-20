package com.example.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class BackendApplicationTests {
    @Autowired
    private MockMvc mvc;

    MovieRepo movieRepo = mock(MovieRepo.class);
    MovieService movieService = new MovieService(movieRepo);

    @Test
    void MovieRepo_MovieService_Test() {
        Movie movie = new Movie(1, "Die Verurteilten", 1994, "https://www.moviejones.de/facebook/bilder/filme/001/1476_p.jpg");
        List<Movie> movie1 = new ArrayList<>(List.of(movie));
        when(movieRepo.getAllMovies()).thenReturn(movie1);

        List<Movie> actual = movieService.getAllMovies();

        Assertions.assertEquals(List.of(movie), actual);
        verify(movieRepo).getAllMovies();
    }

    @Test
    void getAllMovies_shouldReturnAllMovies() throws Exception {
        String expectedJSON = """
                [
                    {
                        "id": 1,
                        "name": "Die Verurteilten",
                        "year": 1994,
                        "imgURL": "https://www.moviejones.de/facebook/bilder/filme/001/1476_p.jpg"
                    },
                    {
                        "id": 2,
                        "name": "Der Pate",
                        "year": 1972,
                        "imgURL": "https://up.picr.de/38838835jo.jpg"
                    },
                    {
                        "id": 3,
                        "name": "The Dark Knight",
                        "year": 2008,
                        "imgURL": "https://ae01.alicdn.com/kf/HTB1NqBBhJfJ8KJjy0Feq6xKEXXaU.jpg"
                    },
                    {
                        "id": 4,
                        "name": "Der Pate 2",
                        "year": 1974,
                        "imgURL": "https://media.services.cinergy.ch/media/box1600/9df939a5498a23f83a877dbcb5c2976c9bd32559.jpg"
                    },
                    {
                        "id": 5,
                        "name": "Die zwölf Geschworenen",
                        "year": 1957,
                        "imgURL": "https://image.film.at/images/cfs_1864w/5028324/wO931IxQ9cmBRJmQ7ZHjvRygaKH.jpg"
                    },
                    {
                        "id": 6,
                        "name": "Schindlers Liste",
                        "year": 1993,
                        "imgURL": "https://buzz.tt/media/posters/2270/posters_3_1500.jpg"
                    },
                    {
                        "id": 7,
                        "name": "Der Herr der Ringe: Die Rückkehr des Königs",
                        "year": 2003,
                        "imgURL": "https://static.kino.de/wp-content/gallery/der-herr-der-ringe-die-rueckkehr-des-koenigs-2003/herr-der-ringe-die-rckkehr-des-knigs-der-2-rcm0x1920u.jpg"
                    },
                    {
                        "id": 8,
                        "name": "Pulp Fiction",
                        "year": 1994,
                        "imgURL": "https://cdn.shopify.com/s/files/1/1416/8662/products/pulp_fiction_1994_french_original_film_art_ab0be132-fe07-4c64-ba85-c2dd6d8e1349_5000x.jpg?v=1569193781"
                    },
                    {
                        "id": 9,
                        "name": "Der Herr der Ringe: Die Gefährten",
                        "year": 2001,
                        "imgURL": "https://2.bp.blogspot.com/-gsprCoUZKf0/URDmQvM-xQI/AAAAAAAAAI8/MZXwH_kL1Ps/s1600/der_herr_der_ringe_-_die_gefaehrten.jpg"
                    },
                    {
                        "id": 10,
                        "name": "Zwei glorreiche Halunken",
                        "year": 1966,
                        "imgURL": "https://image.tmdb.org/t/p/original/pdOqKAVXEtUZdN00mCq6V357X6k.jpg"
                    } 
                ]
                """;

        mvc.perform(MockMvcRequestBuilders.get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    void getMovieById_shouldReturnASingleMovie() throws Exception {
        String expectedJSON = """
                    {
                        "id": 1,
                        "name": "Die Verurteilten",
                        "year": 1994,
                        "imgURL": "https://www.moviejones.de/facebook/bilder/filme/001/1476_p.jpg"
                    }
                """;

        mvc.perform(MockMvcRequestBuilders.get("/api/movies/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }
}
