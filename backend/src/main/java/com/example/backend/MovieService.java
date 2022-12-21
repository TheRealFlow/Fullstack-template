package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepo movieRepo;

    public List<Movie> getAllMovies() {
        return movieRepo.getAllMovies();
    }

    public Movie getMovieById(int id) {
        return movieRepo.getMovieById(id);
    }

    public void deleteMovie(int id) {
        movieRepo.deleteMovie(id);
    }

    public Movie addNewMovie(Movie movie) {
        movie.setId(this.getNewId());
        return movieRepo.addMovie(movie);
    }

    private int getNewId() {
        int id = 0;
        return ++id;
    }
}
