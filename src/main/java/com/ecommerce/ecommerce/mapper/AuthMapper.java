package com.ecommerce.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.ecommerce.dto.RegisterRequest;
import com.ecommerce.ecommerce.dto.auth.AuthResponse;
import com.ecommerce.ecommerce.entity.User;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    User toUser(RegisterRequest request);

    AuthResponse toAuthResponse(User user);
}
