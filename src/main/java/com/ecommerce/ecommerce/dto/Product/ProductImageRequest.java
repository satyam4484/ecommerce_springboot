package com.ecommerce.ecommerce.dto.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductImageRequest(
    @NotBlank(message = "Image URL cannot be blank")
    String imageUrl,

    @NotNull(message = "isPrimary cannot be null")
    boolean isPrimary
) {}