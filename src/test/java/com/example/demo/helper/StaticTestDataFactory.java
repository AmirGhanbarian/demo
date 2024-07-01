package com.example.demo.helper;

import com.example.demo.dto.AddressDto;
import lombok.val;

import java.util.List;

public class StaticTestDataFactory {


    public static List<AddressDto> getTestAddressDto() {
        val address1 = AddressDto.builder()
                .address("address 1")
                .build();
        val address2 = AddressDto.builder()
                .address("address 1")
                .build();
        val address3 = AddressDto.builder()
                .address("address 1")
                .build();
        val address4 = AddressDto.builder()
                .address("address 1")
                .build();

        return List.of(address1, address2, address3, address4);
    }
}
