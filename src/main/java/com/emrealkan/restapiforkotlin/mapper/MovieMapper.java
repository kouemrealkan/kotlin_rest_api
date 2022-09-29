package com.emrealkan.restapiforkotlin.mapper;

import com.emrealkan.restapiforkotlin.dto.MovieResponse;
import com.emrealkan.restapiforkotlin.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "id",source = "id")
    @Mapping(target = "date",source = "date")
    @Mapping(target = "name",source = "name")
    @Mapping(target = "directorName",source = "directorName")
    @Mapping(target = "movieCategories",source = "movieCategories")
    @Mapping(target = "movieDetail",source = "movieDetail")
    @Mapping(target = "movieImgUrl",source = "movieImgUrl")
    public MovieResponse mapToDto(Movie movie);

}
