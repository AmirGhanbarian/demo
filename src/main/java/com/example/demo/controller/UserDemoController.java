package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.helper.Helper;
import com.example.demo.model.DemoUser;
import com.example.demo.model.response.ResponseBuilderDemo;
import com.example.demo.model.response.ResponseDemo;
import com.example.demo.model.response.ResponseErrorDemo;
import com.example.demo.service.UserServiceImpl;
import lombok.val;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserDemoController {
    private final UserServiceImpl userServiceImpl;

    public UserDemoController(UserServiceImpl userServiceImpl) {

        this.userServiceImpl = userServiceImpl;
    }


    @PostMapping
    public ResponseDemo<DemoUser> addUser(@RequestBody UserDto userDto) {
        try {
            return new ResponseBuilderDemo<DemoUser>()
                    .addData(userServiceImpl.createUser(userDto))
                    .build();
        } catch (Exception e) {
            return new ResponseBuilderDemo<DemoUser>().fail().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseDemo<String> deleteUser(@PathVariable Long id) {
        try {
            return new ResponseBuilderDemo<String>()
                    .addData(userServiceImpl.deleteUser(id))
                    .build();
        } catch (Exception e) {
            return new ResponseBuilderDemo<String>().fail().build();
        }
    }


    @GetMapping(value = "/{id}")
    public ResponseDemo<DemoUser> getDemoUserById(@PathVariable Long id) {
        val result = userServiceImpl.getUser(id);
        return Helper.nonNull(result) ?
                new ResponseBuilderDemo<DemoUser>().addData(result).build() :
                new ResponseBuilderDemo<DemoUser>()
                        .error(new ResponseErrorDemo("404", "not found"))
                        .build();
    }

    @PutMapping("/{id}")
    public ResponseDemo<String> updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        val resultMessage = userServiceImpl.updateUser(userDto, id);
        return new ResponseBuilderDemo<String>().addData(resultMessage).build();
    }

}
