package com.tecnoin.sv.application.service;

import com.tecnoin.sv.application.dto.UserLoginDto;
import com.tecnoin.sv.application.dto.UserRegistrationDto;
import com.tecnoin.sv.application.usecase.UserAuthenticationUseCase;
import com.tecnoin.sv.application.usecase.UserRegistrationUseCase;
import com.tecnoin.sv.domain.entity.User;
import com.tecnoin.sv.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserService {

    private final UserRegistrationUseCase userRegistrationUseCase;
    private final UserAuthenticationUseCase userAuthenticationUseCase;

    @Autowired
    public ApplicationUserService(UserRegistrationUseCase userRegistrationUseCase,
                                  UserAuthenticationUseCase userAuthenticationUseCase) {
        this.userRegistrationUseCase = userRegistrationUseCase;
        this.userAuthenticationUseCase = userAuthenticationUseCase;
    }

    @Override
    public User registerUser(UserRegistrationDto registrationDto) {
        return userRegistrationUseCase.registerNewUser(registrationDto);
    }

    @Override
    public User validateUserCredentials(UserLoginDto loginDto) {
        return userAuthenticationUseCase.authenticateUser(loginDto);
    }
}
