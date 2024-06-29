package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.exception.AddressNotFoundException;
import com.example.demo.helper.DtoConvertor;
import com.example.demo.model.Address;
import com.example.demo.model.response.ResponseBuilderDemo;
import com.example.demo.model.response.ResponseDemo;
import com.example.demo.model.response.ResponseErrorDemo;
import com.example.demo.repository.AddressRepository;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/address")
public class AddressController {

    final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @PostMapping
    public ResponseDemo<Address> addAddress(@RequestBody AddressDto addressDto) {

        try {
            return new ResponseBuilderDemo<Address>()
                    .addData(addressRepository.save(DtoConvertor.addressOf(addressDto)))
                    .build();
        } catch (Exception e) {
            return new ResponseBuilderDemo<Address>().fail().build();
        }
    }

    @ExceptionHandler(AddressNotFoundException.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDemo<Address> getAddressById(@PathVariable Long id) {
        val result = addressRepository.findById(id);
        return addressRepository.findById(id).isPresent() ?
                new ResponseBuilderDemo<Address>().addData(result.get()).build() :
                new ResponseBuilderDemo<Address>()
                        .error(new ResponseErrorDemo("404", "not found"))
                        .build();

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseDemo<ArrayList<Address>> getAllAddresses() {
        val result = addressRepository.findAll();
        ArrayList<Address> list = new ArrayList<>();
        result.iterator().forEachRemaining(list::add);
        return new ResponseBuilderDemo<ArrayList<Address>>().addData(list).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseDemo<String> deleteById(@PathVariable Long id) {
        addressRepository.deleteById(id);
        //TODO validation Of deletion should be placed Here
        //isContains
        return new ResponseBuilderDemo<String>().success().build();
    }
}
