package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.exception.AddressNotFoundException;
import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;



    @PostMapping
    public Object addAddress(@RequestBody AddressDto addressDto) {

        try {
            val address=Address.builder()
                    .address(addressDto.getAddress())
                    .build();
            return addressRepository.save(address);

        }catch (Exception e){
            return HttpClientErrorException.create(HttpStatusCode.valueOf(500),
                    "Error while creating entity", null, null, null);
        }


    }

    @ExceptionHandler(AddressNotFoundException.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return addressRepository.findById(id);
    }
}
