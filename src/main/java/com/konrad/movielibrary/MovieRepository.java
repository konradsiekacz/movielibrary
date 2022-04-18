package com.konrad.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> getAllMovies(){
        return jdbcTemplate.query("select id, name, rating from movie",
                BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public Movie getMovieById(int id){
        return jdbcTemplate.queryForObject("select id, name, rating from movie where " + "id = ?",
                BeanPropertyRowMapper.newInstance(Movie.class),id);
    }
}
