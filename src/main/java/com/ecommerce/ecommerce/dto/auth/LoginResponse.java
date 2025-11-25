package com.ecommerce.ecommerce.dto.auth;


public record LoginResponse(
    String accessToken,
    Long expiresIn
) {}
