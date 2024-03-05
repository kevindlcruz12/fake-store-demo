package com.tecnoin.sv.application.service;

import com.tecnoin.sv.application.dto.PaymentDto;
import com.tecnoin.sv.application.usecase.GetPaymentDetailsUseCase;
import com.tecnoin.sv.application.usecase.ProcessPaymentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentApplicationService {

    private final ProcessPaymentUseCase processPaymentUseCase;
    private final GetPaymentDetailsUseCase getPaymentDetailsUseCase;

    @Autowired
    public PaymentApplicationService(ProcessPaymentUseCase processPaymentUseCase, GetPaymentDetailsUseCase getPaymentDetailsUseCase) {
        this.processPaymentUseCase = processPaymentUseCase;
        this.getPaymentDetailsUseCase = getPaymentDetailsUseCase;
    }

    public PaymentDto processPayment(PaymentDto paymentDto) {
        return processPaymentUseCase.execute(paymentDto);
    }

    public PaymentDto getPaymentDetailsByOrderId(Long orderId) {
        return getPaymentDetailsUseCase.execute(orderId);
    }
}
