package com.tecnoin.sv.application.mapper;

import com.tecnoin.sv.application.dto.UserRegistrationDto;
import com.tecnoin.sv.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User userRegistrationDtoToUser(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        user.setRole(registrationDto.getRole());
        return user;
    }
}
