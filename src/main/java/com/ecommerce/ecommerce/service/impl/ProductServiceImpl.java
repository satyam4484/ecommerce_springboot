package com.ecommerce.ecommerce.service.impl;

import org.springframework.http.HttpStatus;

import com.ecommerce.ecommerce.entity.Category;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dto.Product.ProductRequest;
import com.ecommerce.ecommerce.dto.Product.ProductResponse;
import com.ecommerce.ecommerce.dto.common.ApiResponse;
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.entity.User;
import com.ecommerce.ecommerce.exceptions.AppException;
import com.ecommerce.ecommerce.mapper.ProductMapper;
import com.ecommerce.ecommerce.repository.CategoryRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.ecommerce.ecommerce.service.interfaces.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final UserRepository userRepository;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ApiResponse<?> createProduct(Long userId, ProductRequest productRequest) {
    try {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

        // Fetch Category using categoryId from request
        Category category = categoryRepository.findById(productRequest.categoryId())
                .orElseThrow(() -> new AppException("Category not found", HttpStatus.NOT_FOUND));

        // Map request to entity
        Product product = productMapper.toProduct(productRequest);
        product.setSeller(user);
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        ProductResponse productResponse = productMapper.toProductResponse(savedProduct);
        return ApiResponse.success("Product created successfully", productResponse, HttpStatus.CREATED);

    } catch (Exception e) {
        return ApiResponse.failure("Failed to create product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    
}
