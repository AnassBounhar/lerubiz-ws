package com.lerubiz.ws.service;

import com.lerubiz.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {

    UserDto createUser(UserDto use);
    UserDto getUser(String email);
    UserDto getUserByUserId(String userId);
}
