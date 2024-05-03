package com.example.cinemaker.controller;

import com.example.cinemaker.entity.Movie;
import com.example.cinemaker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAll() { return movieService.getAll();}

    @GetMapping("/{movieId}")
    public Optional<Movie> getById(@PathVariable("movieId") Long movieId){
        return movieService.getById(movieId);
    }

    @PostMapping
    public void post(@RequestBody Movie movie) { movieService.save(movie);}

    @DeleteMapping("/{movieId}")
    public void delete(@PathVariable("movieId") Long movieId) {movieService.delete(movieId);}

}
