package com.example.cinemaker.service;

import com.example.cinemaker.entity.Movie;
import com.example.cinemaker.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAll() {return movieRepository.findAll();}

    public Optional<Movie> getById(Long id) {return movieRepository.findById(id);}

    public void save(Movie movie){movieRepository.save(movie);}

    public void delete(Long id) {movieRepository.deleteById(id);}


}
