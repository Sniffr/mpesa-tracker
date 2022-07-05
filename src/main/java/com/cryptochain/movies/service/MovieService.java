package com.cryptochain.movies.service;

import com.cryptochain.movies.entities.Movie;
import com.cryptochain.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    // function to get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    //function to get movie by id
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }
    //function to add movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> addMovies(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }


}
