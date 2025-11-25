package com.ecommerce.ecommerce.security.jwt;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.ecommerce.ecommerce.dto.common.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException {

        // 1. Prefer detailed message if present
        String message = (String) request.getAttribute("jwt_error");
        if (message == null || message.isBlank()) {
            message = authException.getMessage() != null
                    ? authException.getMessage()
                    : "Unauthorized";
        }

        // 2. Build ApiResponse using your helper (it already sets timestamp)
        ApiResponse<?> apiResponse = ApiResponse.failure(
                message,
                HttpStatus.UNAUTHORIZED
        );

        // // 3. Configure HTTP response
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=UTF-8");

        // 4. Write JSON body
        objectMapper.writeValue(response.getOutputStream(), apiResponse);
    }
    
}


