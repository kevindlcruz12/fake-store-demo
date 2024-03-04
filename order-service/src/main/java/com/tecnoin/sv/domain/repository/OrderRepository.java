package com.tecnoin.sv.domain.repository;

import com.tecnoin.sv.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order save(Order order);
    List<Order> findByCustomerId(Long customerId);
}
