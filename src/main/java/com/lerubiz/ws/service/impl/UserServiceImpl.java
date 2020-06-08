package com.lerubiz.ws.service.impl;

import com.lerubiz.ws.io.entity.UserEntity;
import com.lerubiz.ws.io.repository.UserRepository;
import com.lerubiz.ws.service.UserService;
import com.lerubiz.ws.shared.Utils;
import com.lerubiz.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        if (userRepository.findByEmail(user.getEmail()) != null)
            throw new RuntimeException("User already exists !");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId(utils.generateUserId(50));

        UserEntity userStored = userRepository.save(userEntity);
        UserDto returnValue = new UserDto();

        BeanUtils.copyProperties(userStored,returnValue);
        return returnValue;
    }
}
