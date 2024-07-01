package com.example.demo.helper;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Address;
import com.example.demo.model.DemoUser;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class DtoConvertor {

    public static Address addressOf(AddressDto addressDto) {
        return new Address(addressDto.getAddress());

    }


    public static List<Address> addressDtoListToAddressList(List<AddressDto> addressDtoList) {
        List<Address> addressList = new ArrayList<>();
        if (Helper.nonNull(addressDtoList)) {
            for (val addressDto : addressDtoList) {
                addressList.add(Address.builder()
                        .address(addressDto.getAddress())
                        .build());
            }
            return addressList;
        }
        return new ArrayList<>();
    }

    public static DemoUser demoUserOf(UserDto userDto) {
        val demoUser = new DemoUser();
        List<Address> addressList = new ArrayList<>();
        for (AddressDto addressDto : userDto.getAddressList()) {
            addressList.add(DtoConvertor.addressOf(addressDto));
        }
        demoUser.setAddress(addressList);
        demoUser.setUsername(userDto.getUsername());
        return demoUser;
    }
}
