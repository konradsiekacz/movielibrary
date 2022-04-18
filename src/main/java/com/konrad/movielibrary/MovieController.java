package com.konrad.movielibrary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieRepository.getAllMovies();
    }
}
