package com.ecommerce.ecommerce.service.interfaces;

import com.ecommerce.ecommerce.dto.RegisterRequest;
import com.ecommerce.ecommerce.dto.auth.LoginRequest;
import com.ecommerce.ecommerce.dto.common.ApiResponse;

public interface AuthService {
   ApiResponse<?>register(RegisterRequest request);
   ApiResponse<?>login(LoginRequest request);

}
