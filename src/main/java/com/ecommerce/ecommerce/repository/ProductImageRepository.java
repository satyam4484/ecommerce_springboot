package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    
}
