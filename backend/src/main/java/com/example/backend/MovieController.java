package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping()
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieService.getMovieById(id);
    }

    @DeleteMapping("{id}")
    void deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
    }

    @PostMapping
    public Movie addNewMovie (@RequestBody Movie movie) {
        return movieService.addNewMovie(movie);
    }
}
