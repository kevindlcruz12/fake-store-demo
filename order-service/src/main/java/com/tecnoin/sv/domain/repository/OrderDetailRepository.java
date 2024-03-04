package com.tecnoin.sv.domain.repository;

import com.tecnoin.sv.domain.entity.Order;
import com.tecnoin.sv.domain.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
}
