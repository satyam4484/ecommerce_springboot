package com.ecommerce.ecommerce.mapper;


import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.Bean;

import com.ecommerce.ecommerce.dto.Category.CategoryRequest;
import com.ecommerce.ecommerce.dto.Category.CategoryResponse;
import com.ecommerce.ecommerce.dto.Category.UpdateCategoryRequest;
import com.ecommerce.ecommerce.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "slugUrl", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Category toCategory(CategoryRequest request);

    CategoryResponse toResponse(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryNameFromDto(UpdateCategoryRequest dto, @MappingTarget Category entity);
    
} 