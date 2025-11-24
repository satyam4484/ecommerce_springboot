package com.ecommerce.ecommerce.dto.auth;

public record AuthResponse(
    String accessToken,
    String refreshToken,
    Long id,
    String email
) {}