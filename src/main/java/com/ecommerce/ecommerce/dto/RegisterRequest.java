package com.ecommerce.ecommerce.dto;

public record RegisterRequest (
    String email,
    String fullName,
    String password,
    String role
) {}
