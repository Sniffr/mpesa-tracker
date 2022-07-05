package com.cryptochain.movies.controller.rest;

import com.cryptochain.movies.entities.Movie;
import com.cryptochain.movies.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    //Initialize a logger for this class
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    //controller method to get all movies from movie service
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        //Log the call using logger
        logger.info("getAllMovies called");
        return movieService.getAllMovies();
    }

    @PostMapping("/movies")
    public List<Movie> addMovies(@RequestBody List<Movie> movies) {
        logger.info("addMovie called");
        return movieService.addMovies(movies);
    }
    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie movie) {
        logger.info("addMovie called");
        return movieService.addMovie(movie);
    }


}
