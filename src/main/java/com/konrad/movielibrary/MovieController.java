package com.konrad.movielibrary;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }
}
