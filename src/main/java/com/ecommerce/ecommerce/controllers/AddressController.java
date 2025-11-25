package com.ecommerce.ecommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dto.Address.AddressRequest;
import com.ecommerce.ecommerce.dto.common.ApiResponse;
import com.ecommerce.ecommerce.service.interfaces.AddressService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> addAddress(@Valid @RequestBody AddressRequest addressRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = Long.parseLong(authentication.getName());
        ApiResponse<?> response = addressService.addAddress(userId, addressRequest);
        return ResponseEntity.status(response.getStatus()).body(response);

    }
    
}
