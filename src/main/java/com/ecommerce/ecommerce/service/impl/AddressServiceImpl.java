package com.ecommerce.ecommerce.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dto.Address.AddressRequest;
import com.ecommerce.ecommerce.dto.Address.AddressResponse;
import com.ecommerce.ecommerce.dto.common.ApiResponse;
import com.ecommerce.ecommerce.entity.Address;
import com.ecommerce.ecommerce.entity.User;
import com.ecommerce.ecommerce.exceptions.AppException;
import com.ecommerce.ecommerce.mapper.AddressMapper;
import com.ecommerce.ecommerce.repository.AdressRepository;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.ecommerce.ecommerce.service.interfaces.AddressService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
    private final AdressRepository addressRepository;
    private final UserRepository userRepository;
    private final AddressMapper addressMapper;
    
    public ApiResponse<?> addAddress(Long userId, AddressRequest addressRequest) {
        try{
            User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
            Address address = addressMapper.toAddress(addressRequest);
            address.setUser(user);
            Address savedAddress = addressRepository.save(address);
            AddressResponse addressResponse = addressMapper.toDto(savedAddress);
            return ApiResponse.success("Address added successfully", addressResponse, HttpStatus.CREATED);
            
        }catch(Exception e){
            return ApiResponse.failure("Failed to add address: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ApiResponse<?> getUserAddress(Long userId) {
        try{
            List<Address> addresses= addressRepository.findByUserId(userId);
            List<AddressResponse> dtoAddress = addressMapper.toDtoList(addresses);
            return ApiResponse.success("User Address Retrived Successfully", dtoAddress,HttpStatus.OK);
        }catch(Exception e) {
            return ApiResponse.failure("Failed to get address f: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
