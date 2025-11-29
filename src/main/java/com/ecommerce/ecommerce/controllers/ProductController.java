package com.ecommerce.ecommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dto.Product.ProductRequest;
import com.ecommerce.ecommerce.dto.common.ApiResponse;
import com.ecommerce.ecommerce.service.interfaces.ProductService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    // seller Endpoints
    @PostMapping
    public ResponseEntity<ApiResponse<?>> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = Long.parseLong(authentication.getName());
        ApiResponse<?> response = productService.createProduct(userId,productRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // page, size, sortBy, sortDir, categoryId (optional)
    @GetMapping("/seller")
    public ResponseEntity<ApiResponse<?>> getSellerProducts() {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateProduct(@PathVariable Long id) {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteProduct(@PathVariable Long id   ) {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);  
    }


    // Admin functionss
    @PostMapping("/approve/{id}")
    public ResponseEntity<ApiResponse<?>> approveProduct(@PathVariable Long id) {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);  
    }

    @PostMapping("/reject/{id}")
    public ResponseEntity<ApiResponse<?>> rejectProduct(@PathVariable Long id) {
        ApiResponse<?> response = null; 
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    
    // page, size, sortBy, sortDir, categoryId (optional)
    @GetMapping("/")
    public ResponseEntity<ApiResponse<?>> getAllProducts() {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> toggleProductStatus(@PathVariable Long id) {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);
    }


    // Customer Endpoints
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getProductById(@PathVariable Long id) {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse<?>> getProductsByCategory(@PathVariable Long categoryId) {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);  
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<?>> searchProducts() {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/filter")
    public ResponseEntity<ApiResponse<?>> filterProducts() {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    
    @GetMapping("featured")
    public ResponseEntity<ApiResponse<?>> getFeaturedProducts() {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);  
    }

    @GetMapping("/trending")
    public ResponseEntity<ApiResponse<?>> getTrendingProducts() {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);  
    }

    @GetMapping("/related")
    public ResponseEntity<ApiResponse<?>> getRelatedProducts() {
        ApiResponse<?> response = null;
        return ResponseEntity.status(response.getStatus()).body(response);  
    }
}
