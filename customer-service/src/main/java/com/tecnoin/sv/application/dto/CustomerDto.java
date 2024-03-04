package com.tecnoin.sv.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
}

