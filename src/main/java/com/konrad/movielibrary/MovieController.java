package com.konrad.movielibrary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/")
    public List<Movie> getAllMovies(){
        return movieRepository.getAllMovies();
    }
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") int id){
       return movieRepository.getMovieById(id);
    }

}
