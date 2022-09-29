package com.emrealkan.restapiforkotlin.service;

import com.emrealkan.restapiforkotlin.dto.BookRequest;
import com.emrealkan.restapiforkotlin.dto.CategoryRequest;
import com.emrealkan.restapiforkotlin.dto.CategoryResponse;
import com.emrealkan.restapiforkotlin.mapper.CategoryMapper;
import com.emrealkan.restapiforkotlin.model.Book;
import com.emrealkan.restapiforkotlin.model.Category;
import com.emrealkan.restapiforkotlin.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Transactional
    public void saveCategory(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.getName());

        categoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    public List<CategoryResponse> getAllCategories(){
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
