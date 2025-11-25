package com.ecommerce.ecommerce.service.interfaces;

import com.ecommerce.ecommerce.dto.Address.AddressRequest;
import com.ecommerce.ecommerce.dto.common.ApiResponse;


public interface AddressService {
    ApiResponse<?> addAddress(Long userId, AddressRequest addressRequest);
    
}
