package com.emrealkan.restapiforkotlin.mapper;

import com.emrealkan.restapiforkotlin.dto.MovieCategoryResponse;
import com.emrealkan.restapiforkotlin.model.MovieCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieCategoryMapper {
    @Mapping(target = "id",source = "id")
    @Mapping(target = "name",source = "name")
    @Mapping(target = "movies",source = "movies")
    public MovieCategoryResponse mapToDto(MovieCategory movieCategory);
}
