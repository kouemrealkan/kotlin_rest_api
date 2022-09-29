package com.emrealkan.restapiforkotlin.dto;

import com.emrealkan.restapiforkotlin.model.MovieCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
    private Long id;
    private String name;
    private String date;
    private String directorName;
    private String movieImgUrl;
    private String movieDetail;
    private List<MovieCategory> movieCategories;
}
