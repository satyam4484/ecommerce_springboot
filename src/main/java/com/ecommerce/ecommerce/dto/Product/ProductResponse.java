package com.ecommerce.ecommerce.dto.Product;

import java.time.LocalDateTime;
import java.util.List;

public record ProductResponse(
        Long id,
        String title,
        String description,
        int price,
        int stock,
        Long categoryId,
        String categoryName,
        String brand,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<ProductImageResponse> images
) {}
