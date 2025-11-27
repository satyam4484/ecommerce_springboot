package com.ecommerce.ecommerce.dto.Product;

import java.time.LocalDateTime;

public record ProductImageResponse(
        Long id,
        String imageUrl,
        boolean isPrimary,
        LocalDateTime createdAt
) {}
