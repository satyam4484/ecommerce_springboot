package com.ecommerce.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.ecommerce.dto.Product.ProductImageRequest;
import com.ecommerce.ecommerce.dto.Product.ProductImageResponse;
import com.ecommerce.ecommerce.dto.Product.ProductRequest;
import com.ecommerce.ecommerce.dto.Product.ProductResponse;
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.entity.ProductImage;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "seller", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "images", source = "images")
    @Mapping(target = "category", ignore = true)
    Product toProduct(ProductRequest request);
    
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "brand", source = "seller.fullName")
    ProductResponse toProductResponse(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "primary", source = "isPrimary")
    ProductImage toProductImage(ProductImageRequest request);

    @Mapping(target = "isPrimary", source = "primary")
    ProductImageResponse toProductImageResponse(ProductImage productImage);
}