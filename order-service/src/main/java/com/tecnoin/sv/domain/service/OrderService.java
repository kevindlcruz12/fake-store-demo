package com.tecnoin.sv.domain.service;

import com.tecnoin.sv.domain.entity.Order;
import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
    void updateOrder(Order order);
    void deleteOrder(Long orderId);
}
