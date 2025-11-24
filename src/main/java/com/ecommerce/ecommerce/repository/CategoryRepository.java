package com.ecommerce.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    Optional<Category> findBySlugUrl(String slugUrl);
    Optional<Category> findByName(String name);

}
