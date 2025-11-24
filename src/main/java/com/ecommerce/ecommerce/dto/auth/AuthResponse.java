package com.ecommerce.ecommerce.dto.auth;

public record AuthResponse(
    Long id,
    String email,
    String fullName,
    String role
) {}