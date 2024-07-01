package com.example.demo.integration;


import com.example.demo.integration.context.BaseIntTest;
import com.example.demo.model.Address;
import com.example.demo.model.DemoUser;
import com.example.demo.repository.UserRepository;
import lombok.extern.java.Log;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Level;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
//        classes = DemoApplication.class)
//@AutoConfigureMockMvc
@Log
public class UserRepositoryIntTest extends BaseIntTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void saveDemoUserTest() {

        try {


            //prepare
            val demoUser = DemoUser.builder()
                    .id(1L)
                    .username("ali")
                    .address(List.of(Address.builder()
                            .address("آدرس خونه علی")
                            .build()))
                    .build();

            //action
            assertDoesNotThrow(() -> userRepository.save(demoUser));


            //assertion
            val result = userRepository.findById(demoUser.getId());
            assertThat(result).isPresent();
            assertThat(result.get().getAddress().size()).isEqualTo(1);
            assertThat(result.get().getAddress().get(0).getAddress()).isEqualTo("آدرس خونه علی");
        } catch (Exception e) {
            log.log(Level.ALL, e.getMessage());
        } finally {
            userRepository.deleteAll();
        }
    }

}
