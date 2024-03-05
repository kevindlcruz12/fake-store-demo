package com.tecnoin.sv.application.usecase;

import com.tecnoin.sv.application.dto.PaymentDto;
import com.tecnoin.sv.application.mapper.PaymentMapper;
import com.tecnoin.sv.domain.entity.Payment;
import com.tecnoin.sv.domain.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessPaymentUseCase {

    private final PaymentRepository paymentRepository;

    @Autowired
    public ProcessPaymentUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentDto execute(PaymentDto paymentDto) {
        Payment payment = PaymentMapper.fromDto(paymentDto);
        payment.setStatus("PROCESSED");
        Payment savedPayment = paymentRepository.save(payment);
        return PaymentMapper.toDto(savedPayment);
    }
}