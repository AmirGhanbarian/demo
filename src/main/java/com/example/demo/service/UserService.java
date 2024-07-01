package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.DemoUser;

public interface UserService {

    String updateUser(UserDto userDto, Long id);

    String deleteUser(Long id);

    DemoUser getUser(Long id);

    DemoUser createUser(UserDto userDto) throws Exception;

    void deleteAll();
}
