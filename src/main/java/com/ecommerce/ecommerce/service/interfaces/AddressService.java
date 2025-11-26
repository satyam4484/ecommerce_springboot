package com.ecommerce.ecommerce.service.interfaces;

import com.ecommerce.ecommerce.dto.Address.AddressRequest;
import com.ecommerce.ecommerce.dto.Address.AddressUpdateRequest;
import com.ecommerce.ecommerce.dto.common.ApiResponse;

public interface AddressService {
    ApiResponse<?> addAddress(Long userId, AddressRequest addressRequest);
    ApiResponse<?> getUserAddress(Long userId);
    ApiResponse<?> updateAddress(Long userId, Long addressId, AddressUpdateRequest addressRequest);
    ApiResponse<?> deleteAddress(Long addressId);
    
}
