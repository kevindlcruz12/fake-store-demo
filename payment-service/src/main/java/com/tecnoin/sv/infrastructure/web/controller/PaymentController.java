package com.tecnoin.sv.infrastructure.web.controller;

import com.tecnoin.sv.application.dto.PaymentDto;
import com.tecnoin.sv.application.service.PaymentApplicationService;
import com.tecnoin.sv.shared.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentApplicationService paymentService;

    @Autowired
    public PaymentController(PaymentApplicationService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<?> processPayment(@RequestBody PaymentDto paymentDto) {
        PaymentDto processedPayment = paymentService.processPayment(paymentDto);
        return ResponseEntity.ok(ApiResponse.success(processedPayment));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getPaymentDetailsByOrderId(@PathVariable Long orderId) {
        PaymentDto paymentDetails = paymentService.getPaymentDetailsByOrderId(orderId);
        return ResponseEntity.ok(ApiResponse.success(paymentDetails));
    }
}