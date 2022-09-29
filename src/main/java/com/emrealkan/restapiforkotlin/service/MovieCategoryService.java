package com.emrealkan.restapiforkotlin.service;

import com.emrealkan.restapiforkotlin.dto.MovieCatRequest;
import com.emrealkan.restapiforkotlin.dto.MovieCategoryResponse;
import com.emrealkan.restapiforkotlin.dto.MovieResponse;
import com.emrealkan.restapiforkotlin.mapper.MovieCategoryMapper;
import com.emrealkan.restapiforkotlin.model.MovieCategory;
import com.emrealkan.restapiforkotlin.repository.MovieCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class MovieCategoryService {
    private final MovieCategoryRepository movieCategoryRepository;
    private final MovieCategoryMapper movieCategoryMapper;


    @Transactional(readOnly = true)
    public List<MovieCategoryResponse> getAllMovieCategories(){
        return movieCategoryRepository.findAll()
                .stream()
                .map(movieCategoryMapper::mapToDto)
                .collect(Collectors.toList());

    }

    @Transactional
    public void saveMovieCat(MovieCatRequest movieCatRequest){
        MovieCategory movieCategory = new MovieCategory();
        movieCategory.setName(movieCatRequest.getName());

        movieCategoryRepository.save(movieCategory);


    }

}
