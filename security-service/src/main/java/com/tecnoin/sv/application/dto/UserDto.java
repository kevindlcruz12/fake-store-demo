package com.tecnoin.sv.application.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String role;
}