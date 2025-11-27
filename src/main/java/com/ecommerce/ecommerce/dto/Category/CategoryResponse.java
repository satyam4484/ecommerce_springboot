package com.ecommerce.ecommerce.dto.Category;

import java.time.LocalDateTime;

public record CategoryResponse(
    Long id,
    String name,
    String description,
    String slugUrl,
    LocalDateTime createdAt
) {}

