package com.emrealkan.restapiforkotlin.dto;

import com.emrealkan.restapiforkotlin.model.Movie;
import lombok.Data;

import java.util.List;

@Data
public class MovieCategoryResponse {

    private Long id;
    private String name;
    private List<Movie> movies;

}
