package com.tecnoin.sv.infrastructure.repository;

import com.tecnoin.sv.domain.entity.User;
import com.tecnoin.sv.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository {

    @Override
    default Optional<User> findByEmail(String email) {
        return this.findByEmail(email);
    }
}
