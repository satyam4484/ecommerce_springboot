package com.ecommerce.ecommerce.dto.Product;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
    @NotBlank(message = "Title is required")
    String title,
    String description,

    @Min(value = 0, message = "Price must be non-negative") 
    Integer price,

    @Min(value = 0, message = "Stock must be non-negative")
    Integer stock,
    
    @NotNull(message = "Category ID is required")
    Long categoryId,

    @NotBlank(message = "Status is required")
    String status,
    
    List<ProductImageRequest> images
) {}
