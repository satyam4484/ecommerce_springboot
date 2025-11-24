package com.ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entity.Order;
import com.ecommerce.ecommerce.entity.User;
import com.ecommerce.ecommerce.enums.OrderStatus;


public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByCustomer(User customer);
    List<Order> findByStatus(String status);
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByStatus(OrderStatus status);

}
