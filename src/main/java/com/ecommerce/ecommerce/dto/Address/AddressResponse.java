package com.ecommerce.ecommerce.dto.Address;


public record AddressResponse(
        Long id,
        String addressLine1,
        String addressLine2,
        String city,
        String state,
        String postalCode,
        String country,
        String contactNumber
) {}
