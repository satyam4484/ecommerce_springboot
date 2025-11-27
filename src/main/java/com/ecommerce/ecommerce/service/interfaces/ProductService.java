package com.ecommerce.ecommerce.service.interfaces;

import com.ecommerce.ecommerce.dto.Product.ProductRequest;
import com.ecommerce.ecommerce.dto.common.ApiResponse;

public interface ProductService {
    ApiResponse<?> createProduct(Long userId, ProductRequest productRequest);
}
