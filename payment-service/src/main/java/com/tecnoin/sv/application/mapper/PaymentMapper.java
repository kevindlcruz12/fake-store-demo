package com.tecnoin.sv.application.mapper;

import com.tecnoin.sv.application.dto.PaymentDto;
import com.tecnoin.sv.domain.entity.Payment;

public class PaymentMapper {

    public static PaymentDto toDto(Payment payment) {
        PaymentDto dto = new PaymentDto();
        dto.setOrderId(payment.getOrderId());
        dto.setAmount(payment.getAmount());
        dto.setStatus(payment.getStatus());
        dto.setPaymentType(payment.getPaymentType());
        dto.setPaymentDate(payment.getPaymentDate());
        return dto;
    }

    public static Payment fromDto(PaymentDto dto) {
        Payment payment = new Payment();
        payment.setOrderId(dto.getOrderId());
        payment.setAmount(dto.getAmount());
        payment.setStatus(dto.getStatus());
        payment.setPaymentType(dto.getPaymentType());
        payment.setPaymentDate(dto.getPaymentDate());
        return payment;
    }
}
