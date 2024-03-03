package com.tecnoin.sv.application.usecase;

import com.tecnoin.sv.application.dto.UserLoginDto;
import com.tecnoin.sv.domain.entity.User;
import com.tecnoin.sv.domain.exception.AuthenticationException;
import com.tecnoin.sv.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationUseCase {

    private final UserRepository userRepository;

    @Autowired
    public UserAuthenticationUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User authenticateUser(UserLoginDto loginDto) {
        return userRepository.findByEmail(loginDto.getEmail())
                .filter(user -> checkPassword(loginDto.getPassword(), user.getPassword()))
                .orElseThrow(() -> new AuthenticationException("Invalid credentials."));
    }

    private boolean checkPassword(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}