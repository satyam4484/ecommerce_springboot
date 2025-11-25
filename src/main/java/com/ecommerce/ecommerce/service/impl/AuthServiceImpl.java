package com.ecommerce.ecommerce.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dto.RegisterRequest;
import com.ecommerce.ecommerce.dto.auth.AuthResponse;
import com.ecommerce.ecommerce.dto.auth.LoginRequest;
import com.ecommerce.ecommerce.dto.auth.LoginResponse;
import com.ecommerce.ecommerce.dto.common.ApiResponse;
import com.ecommerce.ecommerce.entity.User;
import com.ecommerce.ecommerce.exceptions.AppException;
import com.ecommerce.ecommerce.mapper.AuthMapper;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.ecommerce.ecommerce.security.jwt.JwtService;
import com.ecommerce.ecommerce.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public ApiResponse<?>register(RegisterRequest request) {
        try{
            if(userRepository.existsByEmail(request.email())){
                return ApiResponse.failure("Email already in use",HttpStatus.BAD_REQUEST);
            }
            User user = authMapper.toUser(request);
            user.setPassword(passwordEncoder.encode(request.password()));
            userRepository.save(user);
            AuthResponse auth = authMapper.toAuthResponse(user);
            return ApiResponse.success("Registration successful", auth, HttpStatus.CREATED);    
        }catch(Exception e){
            throw new AppException("Registration failed " +  e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ApiResponse<?>login(LoginRequest request) {
        try{
            User user = userRepository.findByEmail(request.email()).orElseThrow(()-> new AppException("User not found",HttpStatus.NOT_FOUND));
            if(!passwordEncoder.matches(request.password(), user.getPassword())){
                return ApiResponse.failure("Invalid credentials",HttpStatus.UNAUTHORIZED);
            }
            String accessToken = jwtService.generateAccessToken(user);
            Long expiresIn = jwtService.getExpirationInMs();
            LoginResponse loginResponse = authMapper.toLoginResponse(accessToken, expiresIn);
            return ApiResponse.success("Login successful", loginResponse, HttpStatus.OK);
        }catch(Exception e){
            throw new AppException("Login failed " +  e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
