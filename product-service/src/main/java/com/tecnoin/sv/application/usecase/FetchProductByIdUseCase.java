package com.tecnoin.sv.application.usecase;

import com.tecnoin.sv.application.dto.ProductDto;

public interface FetchProductByIdUseCase {
    ProductDto execute(Long id);
}