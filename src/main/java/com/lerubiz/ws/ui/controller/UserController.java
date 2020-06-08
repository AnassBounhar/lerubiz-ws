package com.lerubiz.ws.ui.controller;

import com.lerubiz.ws.service.UserService;
import com.lerubiz.ws.shared.dto.UserDto;
import com.lerubiz.ws.ui.model.request.UserDetailsRequestModel;
import com.lerubiz.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        return "Get user is called.";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @DeleteMapping
    public String deleteUser(){
        return "Delete user is called.";
    }

    @PutMapping
    public String updateUser(){
        return "Update user is called.";
    }
}
