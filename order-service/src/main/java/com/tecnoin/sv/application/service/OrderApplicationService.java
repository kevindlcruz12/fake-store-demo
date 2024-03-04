package com.tecnoin.sv.application.service;

import com.tecnoin.sv.application.dto.OrderDetailDto;
import com.tecnoin.sv.application.dto.OrderDto;
import com.tecnoin.sv.application.mapper.OrderMapper;
import com.tecnoin.sv.domain.entity.Order;
import com.tecnoin.sv.domain.entity.OrderDetail;
import com.tecnoin.sv.domain.exception.OrderNotFoundException;
import com.tecnoin.sv.domain.repository.OrderDetailRepository;
import com.tecnoin.sv.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderApplicationService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;


    public OrderApplicationService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Transactional
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = OrderMapper.orderDtoToOrder(orderDto);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.orderToOrderDto(savedOrder);
    }

    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        return OrderMapper.orderToOrderDto(order);
    }

    public List<OrderDto> getAllOrdersByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders.stream()
                .map(OrderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDto updateOrderStatus(Long orderId, String newStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        order.setStatus(newStatus);
        Order updatedOrder = orderRepository.save(order);
        return OrderMapper.orderToOrderDto(updatedOrder);
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        order.setStatus("CANCELLED");
        orderRepository.save(order);
    }

    @Transactional
    public OrderDetailDto addOrderDetail(Long orderId, OrderDetailDto orderDetailDto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        OrderDetail orderDetail = OrderMapper.orderDetailDtoToOrderDetail(orderDetailDto);
        orderDetail.setOrder(order); // Asegurar la relación
        orderDetail = orderDetailRepository.save(orderDetail);
        return OrderMapper.orderDetailToOrderDetailDto(orderDetail);
    }

    @Transactional
    public void removeOrderDetail(Long detailId) {
        if (!orderDetailRepository.existsById(detailId)) {
            throw new OrderNotFoundException("OrderDetail not found with id: " + detailId);
        }
        orderDetailRepository.deleteById(detailId);
    }

}
