package com.ecommerce.ecommerce.service.interfaces;

import com.ecommerce.ecommerce.dto.Category.CategoryRequest;
import com.ecommerce.ecommerce.dto.Category.UpdateCategoryRequest;
import com.ecommerce.ecommerce.dto.common.ApiResponse;

public interface CategoryService {
    ApiResponse<?> getAllCategories();
    ApiResponse<?> getCategoryById(Long categoryId);
    ApiResponse<?> createCategory(CategoryRequest categoryRequest);
    ApiResponse<?> updateCategory(Long categoryId, UpdateCategoryRequest updateCategoryRequest);
    ApiResponse<?> deleteCategory(Long categoryId);
} 
