package com.tecnoin.sv.application.mapper;

import com.tecnoin.sv.application.dto.OrderDto;
import com.tecnoin.sv.application.dto.OrderDetailDto;
import com.tecnoin.sv.domain.entity.Order;
import com.tecnoin.sv.domain.entity.OrderDetail;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public static OrderDto orderToOrderDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setOrderId(order.getOrderId());
        dto.setCustomerId(order.getCustomerId());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        dto.setTotal(order.getTotal());

        if (order.getOrderDetails() != null) {
            dto.setOrderDetails(order.getOrderDetails().stream()
                    .map(OrderMapper::orderDetailToOrderDetailDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public static Order orderDtoToOrder(OrderDto dto) {
        Order order = new Order();
        order.setOrderId(dto.getOrderId());
        order.setCustomerId(dto.getCustomerId());
        order.setOrderDate(dto.getOrderDate());
        order.setStatus(dto.getStatus());
        order.setTotal(dto.getTotal());


        return order;
    }

    public static OrderDetailDto orderDetailToOrderDetailDto(OrderDetail detail) {
        OrderDetailDto dto = new OrderDetailDto();
        dto.setDetailId(detail.getDetailId());
        dto.setOrderId(detail.getOrder().getOrderId());
        dto.setProductId(detail.getProductId());
        dto.setQuantity(detail.getQuantity());
        dto.setPrice(detail.getPrice());

        return dto;
    }

    public static OrderDetail orderDetailDtoToOrderDetail(OrderDetailDto dto) {
        OrderDetail orderDetail = new OrderDetail();
        // Aquí necesitaríamos instanciar y configurar el objeto Order si es necesario, o manejarlo externamente
        orderDetail.setDetailId(dto.getDetailId());
        orderDetail.setProductId(dto.getProductId());
        orderDetail.setQuantity(dto.getQuantity());
        orderDetail.setPrice(dto.getPrice());
        return orderDetail;
    }
}
