package com.tecnoin.sv.application.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class OrderDetailDto {
    private Long detailId;
    private Long orderId;
    private Integer productId;
    private Integer quantity;
    private BigDecimal price;
}
