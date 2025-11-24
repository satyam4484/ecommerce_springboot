package com.ecommerce.ecommerce.dto;


import com.ecommerce.ecommerce.enums.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest (

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email,

    @NotBlank(message = "Full name is required")
    String fullName,

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    String password,

    @Schema(allowableValues = {"CUSTOMER", "SELLER", "ADMIN"}, description = "Role must be either USER or ADMIN")
    Role role
) {}
