package com.tecnoin.sv.domain.service;

import com.tecnoin.sv.domain.entity.Payment;

public interface PaymentService {
    Payment processPayment(Payment payment);
    Payment getPaymentDetailsByOrderId(Long orderId);
}