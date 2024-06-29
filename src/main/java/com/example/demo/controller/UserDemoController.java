package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.AddressNotFoundException;
import com.example.demo.helper.DtoConvertor;
import com.example.demo.model.DemoUser;
import com.example.demo.model.response.ResponseBuilderDemo;
import com.example.demo.model.response.ResponseDemo;
import com.example.demo.model.response.ResponseErrorDemo;
import com.example.demo.repository.UserRepository;
import lombok.val;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserDemoController {
    final UserRepository demoUserRepository;

    public UserDemoController(UserRepository userRepository) {
        this.demoUserRepository = userRepository;
    }


    @PostMapping
    public ResponseDemo<DemoUser> addUser(@RequestBody UserDto userDto) {
        try {
            return new ResponseBuilderDemo<DemoUser>()
                    .addData(demoUserRepository.save(DtoConvertor.demoUserOf(userDto)))
                    .build();
        } catch (Exception e) {
            return new ResponseBuilderDemo<DemoUser>().fail().build();
        }
    }


    @ExceptionHandler(AddressNotFoundException.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDemo<DemoUser> getDemoUserById(@PathVariable Long id) {
        val result = demoUserRepository.findById(id);
        return demoUserRepository.findById(id).isPresent() ?
                new ResponseBuilderDemo<DemoUser>().addData(result.get()).build() :
                new ResponseBuilderDemo<DemoUser>()
                        .error(new ResponseErrorDemo("404", "not found"))
                        .build();
    }

}
