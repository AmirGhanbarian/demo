package com.example.demo.integration;

import com.example.demo.dto.UserDto;
import com.example.demo.helper.StaticTestDataFactory;
import com.example.demo.integration.context.BaseIntTest;
import com.example.demo.service.UserServiceImpl;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


public class UserServiceImplIntTest extends BaseIntTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void createUserTest() throws Exception {

        userServiceImpl.createUser(UserDto.builder()
                .username("username-1")
                .addressList(StaticTestDataFactory.getTestAddressDto())
                .build());

        var result = userServiceImpl.getUser(1L);
        assertThat(result.getUsername().equals("username-1")).isTrue();

        val updateResult = userServiceImpl.updateUser(UserDto.builder().username("username-1").addressList(StaticTestDataFactory.getTestAddressDto()).build(), 1L);
        assertThat(updateResult.equals("success"));


        val updateResultShouldFail = userServiceImpl.updateUser(UserDto.builder().username("username-2").addressList(StaticTestDataFactory.getTestAddressDto()).build(), 3L);
        assertThat(updateResultShouldFail.equals("failure"));


    }


}
