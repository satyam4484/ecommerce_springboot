package com.ecommerce.ecommerce.dto.Category;

public record UpdateCategoryRequest(
    String name,
    String description
) {
}