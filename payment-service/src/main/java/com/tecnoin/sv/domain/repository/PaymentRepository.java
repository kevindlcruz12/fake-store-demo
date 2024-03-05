package com.tecnoin.sv.domain.repository;

import com.tecnoin.sv.domain.entity.Payment;
import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findByOrderId(Long orderId);
}