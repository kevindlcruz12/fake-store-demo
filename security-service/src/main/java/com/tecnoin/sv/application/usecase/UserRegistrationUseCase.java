package com.tecnoin.sv.application.usecase;

import com.tecnoin.sv.application.dto.UserRegistrationDto;
import com.tecnoin.sv.application.mapper.UserMapper;
import com.tecnoin.sv.domain.entity.User;
import com.tecnoin.sv.domain.exception.UserAlreadyExistsException;
import com.tecnoin.sv.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserRegistrationUseCase(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User registerNewUser(UserRegistrationDto registrationDto) {
        userRepository.findByEmail(registrationDto.getEmail()).ifPresent(u -> {
            throw new UserAlreadyExistsException("A user with the given email already exists.");
        });

        User newUser = userMapper.userRegistrationDtoToUser(registrationDto);
        return userRepository.save(newUser);
    }
}
