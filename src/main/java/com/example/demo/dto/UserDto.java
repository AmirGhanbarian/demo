package com.example.demo.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserDto {

    private String username;
    private List<AddressDto> addressList;
}
