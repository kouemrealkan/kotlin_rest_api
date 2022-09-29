package com.emrealkan.restapiforkotlin.mapper;

import com.emrealkan.restapiforkotlin.dto.BookResponse;
import com.emrealkan.restapiforkotlin.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
     @Mapping(target = "id",source = "id")
     @Mapping(target = "isbnNumber",source = "isbnNumber")
     @Mapping(target = "name",source = "name")
     @Mapping(target = "categoryName",source = "category.name")
     @Mapping(target = "categoryId",source = "category.id")
     public BookResponse  mapToDto(Book book);
}
