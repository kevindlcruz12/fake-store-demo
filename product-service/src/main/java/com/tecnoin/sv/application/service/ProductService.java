package com.tecnoin.sv.application.service;

import com.tecnoin.sv.application.dto.ProductDto;
import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
}