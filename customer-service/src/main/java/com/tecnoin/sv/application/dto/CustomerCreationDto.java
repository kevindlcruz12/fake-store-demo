package com.tecnoin.sv.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreationDto {
    private Long userId;
    private String firstName;
    private String lastName;
}
