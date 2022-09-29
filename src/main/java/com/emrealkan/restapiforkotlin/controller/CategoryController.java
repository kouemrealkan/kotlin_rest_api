package com.emrealkan.restapiforkotlin.controller;

import com.emrealkan.restapiforkotlin.dto.BookRequest;
import com.emrealkan.restapiforkotlin.dto.CategoryRequest;
import com.emrealkan.restapiforkotlin.dto.CategoryResponse;
import com.emrealkan.restapiforkotlin.model.Category;
import com.emrealkan.restapiforkotlin.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.status;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
 private final CategoryService categoryService;

    @PostMapping("/save-category")
    public ResponseEntity<Void> createBook(@RequestBody CategoryRequest categoryRequest){
        categoryService.saveCategory(categoryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/category-list")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        return status(HttpStatus.OK).body(categoryService.getAllCategories());
    }
}
