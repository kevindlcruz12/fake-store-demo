package com.tecnoin.sv.infrastructure.web.controller;

import com.tecnoin.sv.application.dto.OrderDto;
import com.tecnoin.sv.application.service.OrderApplicationService;
import com.tecnoin.sv.domain.entity.Order;
import com.tecnoin.sv.shared.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderApplicationService orderService;

    @Autowired
    public OrderController(OrderApplicationService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto order = orderService.createOrder(orderDto);
        return ResponseEntity.ok(ApiResponse.success(orderDto));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        OrderDto order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(ApiResponse.success(order));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getAllOrdersByCustomerId(@PathVariable Long customerId) {
        List<OrderDto> order = orderService.getAllOrdersByCustomerId(customerId);
        return ResponseEntity.ok(ApiResponse.success(order));
    }
}