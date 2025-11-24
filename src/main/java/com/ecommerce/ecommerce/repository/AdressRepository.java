package com.ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entity.Address;
import com.ecommerce.ecommerce.entity.User;

public interface AdressRepository extends JpaRepository<Address, Long> {

    List<Address>findByUser(User user);
    List<Address> findByUserId(Long userId);
    
}
