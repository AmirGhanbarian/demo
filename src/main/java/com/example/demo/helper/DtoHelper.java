package com.example.demo.helper;

import com.example.demo.dto.AddressDto;
import com.example.demo.model.Address;
import lombok.val;

public class DtoHelper {

    public static Address addressOf(AddressDto addressDto){
        return Address.builder()
                .address(addressDto.getAddress())
                .build();
    }
}
