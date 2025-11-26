package com.ecommerce.ecommerce.dto.Address;

public record AddressUpdateRequest(
    String addressLine1,
    String addressLine2,
    String city,
    String state,
    String postalCode,
    String country,
    String contactNumber
) {}

