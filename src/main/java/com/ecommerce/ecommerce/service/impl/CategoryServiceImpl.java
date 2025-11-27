package com.ecommerce.ecommerce.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dto.Category.CategoryRequest;
import com.ecommerce.ecommerce.dto.Category.CategoryResponse;
import com.ecommerce.ecommerce.dto.Category.UpdateCategoryRequest;
import com.ecommerce.ecommerce.dto.common.ApiResponse;
import com.ecommerce.ecommerce.entity.Category;
import com.ecommerce.ecommerce.exceptions.AppException;
import com.ecommerce.ecommerce.mapper.CategoryMapper;
import com.ecommerce.ecommerce.repository.CategoryRepository;
import com.ecommerce.ecommerce.service.interfaces.CategoryService;
import com.ecommerce.ecommerce.utils.SlugUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final SlugUtil slugUtil;

    public ApiResponse<?> getAllCategories() {
        try {
            List<Category> categories = categoryRepository.findAll();
            return ApiResponse.success("Categories retrieved successfully", categories, HttpStatus.OK);
        } catch (Exception e) {
            return ApiResponse.failure(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ApiResponse<?> getCategoryById(Long categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new AppException("Category not found", HttpStatus.NOT_FOUND));
            return ApiResponse.success("Category retrieved successfully", category, HttpStatus.OK);
        } catch (Exception e) {
            return ApiResponse.failure(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ApiResponse<?> createCategory(CategoryRequest categoryRequest) {
        try {
            Category category = categoryMapper.toCategory(categoryRequest);

            // Create slug
            String slug = slugUtil.toSlug(categoryRequest.name());

            // Make slug unique (optional but recommended)
            int counter = 1;
            String originalSlug = slug;

            while (categoryRepository.existsBySlugUrl(slug)) {
                slug = originalSlug + "-" + counter;
                counter++;
            }

            category.setSlugUrl(slug);

            Category savedCategory = categoryRepository.save(category);
            CategoryResponse response = categoryMapper.toResponse(savedCategory);
            return ApiResponse.success("Category created successfully", response, HttpStatus.CREATED);
        } catch (Exception e) {
            return ApiResponse.failure(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ApiResponse<?> updateCategory(Long categoryId, UpdateCategoryRequest updateCategoryRequest) {
        try {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new AppException("Category not found", HttpStatus.NOT_FOUND));
            categoryMapper.updateCategoryNameFromDto(updateCategoryRequest, category);
            Category savedCategory = categoryRepository.save(category);
            CategoryResponse updatedCategory = categoryMapper.toResponse(savedCategory);
            return ApiResponse.success("Category updated successfully", updatedCategory, HttpStatus.OK);
        } catch (Exception e) {
            return ApiResponse.failure(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ApiResponse<?> deleteCategory(Long categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new AppException("Category not found", HttpStatus.NOT_FOUND));
            categoryRepository.delete(category);
            return ApiResponse.success("Category deleted successfully", null, HttpStatus.OK);
        } catch (Exception e) {
            return ApiResponse.failure(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
