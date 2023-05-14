package com.kaianluciano.movie.service;


import com.kaianluciano.movie.modell.MovieModel;
import com.kaianluciano.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    final
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieModel> findAll(){
        return movieRepository.findAll();
    }

    public MovieModel save(MovieModel movieModel) {
        movieRepository.save(movieModel);
        return movieModel;
    }

    public void delet(MovieModel movieModel){
        movieRepository.delete(movieModel);
    }

    public Optional<MovieModel> findById(Long id) {
        return movieRepository.findById(id);
    }






}
