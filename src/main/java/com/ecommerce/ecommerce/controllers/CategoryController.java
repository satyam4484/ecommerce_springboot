package com.ecommerce.ecommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dto.Category.CategoryRequest;
import com.ecommerce.ecommerce.dto.Category.UpdateCategoryRequest;
import com.ecommerce.ecommerce.dto.common.ApiResponse;
import com.ecommerce.ecommerce.service.interfaces.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllCategories() {
        ApiResponse<?> response = categoryService.getAllCategories();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getCategoryById(@PathVariable Long id) {
        ApiResponse<?> response = categoryService.getCategoryById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        ApiResponse<?> response = categoryService.createCategory(categoryRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateCategory(   @PathVariable Long id, @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        ApiResponse<?> response = categoryService.updateCategory(id, updateCategoryRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCategory(   @PathVariable Long id   ) {
        ApiResponse<?> response = categoryService.deleteCategory(id);
        return ResponseEntity.status(response.getStatus()).body(response);        
    }
}
