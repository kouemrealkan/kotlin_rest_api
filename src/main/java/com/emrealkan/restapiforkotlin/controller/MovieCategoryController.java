package com.emrealkan.restapiforkotlin.controller;

import com.emrealkan.restapiforkotlin.dto.MovieCatRequest;
import com.emrealkan.restapiforkotlin.dto.MovieCategoryResponse;
import com.emrealkan.restapiforkotlin.dto.MovieRequest;
import com.emrealkan.restapiforkotlin.dto.MovieResponse;
import com.emrealkan.restapiforkotlin.service.MovieCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("api/v1/movie-category")
@AllArgsConstructor
public class MovieCategoryController {
    private final MovieCategoryService movieCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<MovieCategoryResponse>> getAllMovies(){
        return status(HttpStatus.OK).body(movieCategoryService.getAllMovieCategories());
    }

    @PostMapping("/create-category")
    public ResponseEntity<Void> createCat(@RequestBody MovieCatRequest movieCatRequest){
        movieCategoryService.saveMovieCat(movieCatRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
