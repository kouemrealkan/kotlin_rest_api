package com.emrealkan.restapiforkotlin.dto;

import com.emrealkan.restapiforkotlin.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private Long id;
    private String name;
    private List<BookResponse> books;
}
