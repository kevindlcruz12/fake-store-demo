package com.tecnoin.sv.domain.repository;

import com.tecnoin.sv.domain.entity.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}