package com.emrealkan.restapiforkotlin.mapper;

import com.emrealkan.restapiforkotlin.dto.CategoryResponse;
import com.emrealkan.restapiforkotlin.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id",source = "id")
    @Mapping(target = "name",source = "name")
    @Mapping(target = "books",source = "books")
    public CategoryResponse mapToDto(Category category);
}
