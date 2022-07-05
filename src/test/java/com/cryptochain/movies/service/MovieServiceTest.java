package com.cryptochain.movies.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieServiceTest {
    @Autowired
    private MovieService movieService;
    @Test
    void addMovie() {
    }
    @Test
    void getAllMovies() {
        //assert movieService.getAllMovies() is not null
        assertNotNull(movieService.getAllMovies());
    }

    @Test
    void getMovieById() {
    }


}