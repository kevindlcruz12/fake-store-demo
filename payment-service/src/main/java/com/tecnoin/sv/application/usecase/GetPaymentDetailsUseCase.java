package com.tecnoin.sv.application.usecase;

import com.tecnoin.sv.application.dto.PaymentDto;
import com.tecnoin.sv.application.mapper.PaymentMapper;
import com.tecnoin.sv.domain.entity.Payment;
import com.tecnoin.sv.domain.exception.PaymentNotFoundException;
import com.tecnoin.sv.domain.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetPaymentDetailsUseCase {

    private final PaymentRepository paymentRepository;

    @Autowired
    public GetPaymentDetailsUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentDto execute(Long orderId) {
        Payment payment = paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found for order id: " + orderId));
        return PaymentMapper.toDto(payment);
    }
}