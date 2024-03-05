package com.tecnoin.sv.infrastructure.repository;

import com.tecnoin.sv.domain.entity.Payment;
import com.tecnoin.sv.domain.repository.PaymentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPaymentRepository extends JpaRepository<Payment, Long>, PaymentRepository {
     Optional<Payment> findByOrderId(Long orderId);
}
