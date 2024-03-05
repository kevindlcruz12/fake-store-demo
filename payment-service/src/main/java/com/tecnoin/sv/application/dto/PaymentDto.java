package com.tecnoin.sv.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentDto {
    private Long orderId;
    private BigDecimal amount;
    private String status;
    private String paymentType;
    private LocalDateTime paymentDate;
}