package com.tecnoin.sv.application.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {
    private Long orderId;
    private Long customerId;
    private LocalDateTime orderDate;
    private String status;
    private BigDecimal total;
    private List<OrderDetailDto> orderDetails;
}
