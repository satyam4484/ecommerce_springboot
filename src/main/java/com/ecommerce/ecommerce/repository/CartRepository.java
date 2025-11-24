package com.ecommerce.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entity.Cart;
import com.ecommerce.ecommerce.entity.User;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByCustomerId(Long customerId);
    Optional<Cart> findByCustomer(User customer);
}
