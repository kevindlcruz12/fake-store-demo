package com.tecnoin.sv.domain.service;

import com.tecnoin.sv.application.dto.UserLoginDto;
import com.tecnoin.sv.application.dto.UserRegistrationDto;
import com.tecnoin.sv.domain.entity.User;

public interface UserService {
    User registerUser(UserRegistrationDto user);
    User validateUserCredentials(UserLoginDto loginDto);
}
