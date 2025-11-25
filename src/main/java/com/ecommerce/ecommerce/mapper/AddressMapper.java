package com.ecommerce.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.ecommerce.dto.Address.AddressRequest;
import com.ecommerce.ecommerce.entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Address toAddress(AddressRequest request);
    
}
