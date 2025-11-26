package com.ecommerce.ecommerce.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerce.dto.common.ApiResponse;

public interface ProductImageService {
    ApiResponse<?> uploadProductImage(MultipartFile file);
}
