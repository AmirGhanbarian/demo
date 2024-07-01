package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.helper.DtoConvertor;
import com.example.demo.model.DemoUser;
import com.example.demo.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    public String updateUser(UserDto userDto, Long id) {
        if (userExists(id)) {
            val entity = getUser(id);
            entity.setUsername(userDto.getUsername());
            entity.setAddress(DtoConvertor.addressDtoListToAddressList(userDto.getAddressList()));
            userRepository.save(entity);
            return "success";
        } else {
            return "failure";
        }
    }

    public String deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return "deleted";
        } catch (Exception e) {
            return "fail to delete";
        }
    }

    private boolean userExists(Long id) {
        return userRepository.findById(id).isPresent();
    }

    public DemoUser getUser(Long id) {
        if (userExists(id))
            return userRepository.findById(id).get();
        return null;
    }

    public DemoUser createUser(UserDto userDto) throws Exception {
        if (userDtoIsValid(userDto)) {
            return userRepository.save(DtoConvertor.demoUserOf(userDto));
        } else {
            return null;
        }

    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    private boolean userDtoIsValid(UserDto userDto) {
        return userDto != null;
    }

    private boolean userIsValid(DemoUser demoUser) {
        return demoUser != null;
    }
}
