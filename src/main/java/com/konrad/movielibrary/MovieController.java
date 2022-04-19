package com.konrad.movielibrary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("")
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") int id) {
        return movieRepository.getMovieById(id);
    }

    @PostMapping("")
    public int addMovies(@RequestBody List<Movie> movies) {
        return movieRepository.addMovies(movies);
    }

    @PutMapping("/{id}")
    public int updateMovie(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.getMovieById(id);

        if (movie != null) {
            movie.setName(updatedMovie.getName());
            movie.setRating(updatedMovie.getRating());
            movieRepository.updateMovie(movie);
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdateMovie(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.getMovieById(id);

        if (movie != null) {
            if (updatedMovie.getName() != null) movie.setName(updatedMovie.getName());
            if (updatedMovie.getRating() > 0) movie.setRating(updatedMovie.getRating());

            movieRepository.updateMovie(movie);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int deleteMovieById(@PathVariable("id") int id) {
        return movieRepository.deleteMovie(id);
    }
}
