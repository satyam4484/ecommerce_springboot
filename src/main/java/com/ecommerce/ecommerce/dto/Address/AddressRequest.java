package com.ecommerce.ecommerce.dto.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddressRequest(
    @NotBlank(message = "Address line 1 is required")
    String addressLine1,
    String addressLine2,
    @NotBlank(message = "City is required")
    String city,
    @NotBlank(message = "State is required")
    String state,
    @NotBlank(message = "Postal code is required")
    String postalCode,
    @NotBlank(message = "Country is required")
    String country,
    @NotBlank(message = "Contact number is required")
    @Size(min = 10, max = 15, message = "Contact number must be between 10 and 15 digits")
    String contactNumber
) {}