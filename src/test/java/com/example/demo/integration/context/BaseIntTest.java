package com.example.demo.integration.context;

import com.example.demo.DemoApplication;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DemoApplication.class)
@AutoConfigureMockMvc
public class BaseIntTest {

    @Autowired
    UserService userService;

    @BeforeEach
    public void beforeEach() {
        userService.deleteAll();
    }


}
