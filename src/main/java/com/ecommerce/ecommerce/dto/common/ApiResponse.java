package com.ecommerce.ecommerce.dto.common;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private String message;
    private HttpStatus status;
    private T data;
    private String error;
    private List<String> errorList;
    private LocalDateTime timestamp;

    // SUCCESS WITH DATA + STATUS
    public static <T> ApiResponse<T> success(String message, T data, HttpStatus status) {
        return ApiResponse.<T>builder()
                .message(message)
                .data(data)
                .status(status)
                .timestamp(LocalDateTime.now())
                .build();
    }

    // SUCCESS WITHOUT DATA + STATUS
    public static <T> ApiResponse<T> success(String message, HttpStatus status) {
        return ApiResponse.<T>builder()
                .message(message)
                .status(status)
                .timestamp(LocalDateTime.now())
                .build();
    }

    // FAILURE WITH LIST + STATUS
    public static <T> ApiResponse<T> failure(String error, List<String> errorList, HttpStatus status) {
        return ApiResponse.<T>builder()
                .error(error)
                .errorList(errorList)
                .status(status)
                .timestamp(LocalDateTime.now())
                .build();
    }

    // FAILURE WITHOUT LIST + STATUS
    public static <T> ApiResponse<T> failure(String error, HttpStatus status) {
        return ApiResponse.<T>builder()
                .error(error)
                .status(status)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
