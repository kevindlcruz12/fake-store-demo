package com.tecnoin.sv.domain.service;

import com.tecnoin.sv.domain.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
