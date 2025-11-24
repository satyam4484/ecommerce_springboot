package com.ecommerce.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entity.Category;
import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.entity.User;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findBySellerId(Long sellerId);
    List<Product> findBySeller(User seller);
    List<Product> findByStatus(String status);
    List<Product> findByTitleContainingIgnoreCase(String title);
}