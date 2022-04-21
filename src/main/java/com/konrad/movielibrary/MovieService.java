package com.konrad.movielibrary;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
}
