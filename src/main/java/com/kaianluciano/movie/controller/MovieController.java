package com.kaianluciano.movie.controller;


import com.kaianluciano.movie.modell.MovieModel;
import com.kaianluciano.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/movie")
public class MovieController {

    final
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovies(){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMovie(@PathVariable(value = "id") Long id){
        Optional<MovieModel> movieModelOptional = movieService.findById(id);
        if(!movieModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie Not Found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(movieModelOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> saveMovie(@RequestBody MovieModel movieModel){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.save(movieModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable(value = "id") Long id){

        Optional<MovieModel> movieModel = movieService.findById(id);
        movieService.delet(movieModel.get());

        return ResponseEntity.status(HttpStatus.OK).body("Deu bom");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarMovie(@PathVariable(value = "id") Long id, @RequestBody MovieModel movieModel){

        Optional<MovieModel> movieModelOptional = movieService.findById(id);
        if(!movieModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie Not Found");
        }

        var movieModelPut = movieModelOptional.get();
        movieModelPut.setTitulo(movieModel.getTitulo());
        movieModelPut.setMedia(movieModel.getMedia());
        movieModelPut.setSinopse(movieModel.getSinopse());
        movieModelPut.setAnoLancamento(movieModel.getAnoLancamento());
        movieModelPut.setDiretor(movieModel.getDiretor());

        return ResponseEntity.status(HttpStatus.OK).body(movieService.save(movieModelPut));
    }


}
