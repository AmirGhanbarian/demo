package com.example.demo.integration;

import com.example.demo.DemoApplication;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DemoApplication.class)
@AutoConfigureMockMvc
public class AddressWebIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void addAddressWebTest() throws Exception {

        val expectedResponseJson = """
                {
                  "status": "200",
                  "result": "Succeeded",
                  "error": null,
                  "data": []
                }
                """;
        val result = mvc.perform(MockMvcRequestBuilders.get("/address/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseJson))
                .andExpect(MvcResult::getResponse);


    }

}
