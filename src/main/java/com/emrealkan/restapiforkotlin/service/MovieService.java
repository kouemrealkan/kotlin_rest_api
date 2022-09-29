package com.emrealkan.restapiforkotlin.service;


import com.emrealkan.restapiforkotlin.dto.MovieRequest;
import com.emrealkan.restapiforkotlin.dto.MovieResponse;
import com.emrealkan.restapiforkotlin.mapper.MovieMapper;
import com.emrealkan.restapiforkotlin.model.Movie;
import com.emrealkan.restapiforkotlin.model.MovieCategory;
import com.emrealkan.restapiforkotlin.repository.MovieCategoryRepository;
import com.emrealkan.restapiforkotlin.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieCategoryRepository movieCategoryRepository;
    private final MovieMapper movieMapper;

    @Transactional
    public void saveMovie(MovieRequest movieRequest){
        Movie movie = new Movie();
        movie.setName(movieRequest.getName());
        movie.setDate(movieRequest.getDate());
        movie.setDirectorName(movieRequest.getDirectorName());
        movie.setMovieImgUrl(movieRequest.getMovieImgUrl());
        movie.setMovieCategories(movieRequest.getMovieCategories().stream().map(movieCategory -> {
            MovieCategory mvcategory = movieCategory;
            if(mvcategory.getId() >0){
                mvcategory = movieCategoryRepository.findById(mvcategory.getId()).orElseThrow(()->new RuntimeException("Not Found"));
            }
            mvcategory.addMovie(movie);
            return mvcategory;
        }).collect(Collectors.toList()));

        movieRepository.save(movie);
    }

    @Transactional(readOnly = true)
    public List<MovieResponse> getAllMovies(){
        return movieRepository.findAll()
                .stream()
                .map(movieMapper::mapToDto)
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public Optional<MovieResponse> getMovieById(Long id){
        return movieRepository.findById(id).map(movieMapper::mapToDto);

    }
}
