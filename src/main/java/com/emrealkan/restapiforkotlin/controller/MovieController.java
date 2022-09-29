package com.emrealkan.restapiforkotlin.controller;

import com.emrealkan.restapiforkotlin.dto.MovieRequest;
import com.emrealkan.restapiforkotlin.dto.MovieResponse;
import com.emrealkan.restapiforkotlin.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api/v1/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/save-movie")
    public ResponseEntity<Void> createMovie(@RequestBody MovieRequest movieRequest){
        movieService.saveMovie(movieRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/movie-list")
    public ResponseEntity<List<MovieResponse>> getAllMovies(){
       return status(HttpStatus.OK).body(movieService.getAllMovies());
    }

    @GetMapping("/movie-by-id/{id}")
    public ResponseEntity<Optional<MovieResponse>> getMovieById(@PathVariable Long id){
        return status(HttpStatus.OK).body(movieService.getMovieById(id));
    }



}
