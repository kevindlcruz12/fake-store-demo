package com.tecnoin.sv.domain.service;

import com.tecnoin.sv.domain.entity.OrderDetail;
import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> getOrderDetailsByOrderId(Long orderId);
}
