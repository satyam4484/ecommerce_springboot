package com.ecommerce.ecommerce.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.ecommerce.dto.common.ApiResponse;
import com.ecommerce.ecommerce.service.interfaces.ProductImageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {
    @Value("${app.upload.dir}")
    private String uploadDir;

    public ApiResponse<?> uploadProductImage(MultipartFile file) {
        try {
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            Files.copy(file.getInputStream(), filePath);
            String fileUrl = getFileUrl(fileName);
            return ApiResponse.success("Image uploaded successfully", fileUrl, HttpStatus.CREATED);
        } catch (Exception e) {
            return ApiResponse.failure("Image upload failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String getFileUrl(String fileName) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/product-images/")
                .path(fileName)
                .toUriString();
    }

}
