package com.ecommerce.ecommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerce.dto.common.ApiResponse;
import com.ecommerce.ecommerce.service.interfaces.ProductImageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-images")
public class ProductImageController {

    private final ProductImageService productImageService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<?>> uploadProductImage(@RequestParam("image") MultipartFile file) {
        ApiResponse<?> response = productImageService.uploadProductImage(file);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<?>> addImageToProduct(@RequestParam("productId") Long productId,
            @RequestParam("imageId") Long imageId) {
                ApiResponse<?>response= null;
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<?>> removeImageFromProduct(@RequestParam("productId") Long productId,
            @RequestParam("imageId") Long imageId) {
                ApiResponse<?>response= null;
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
