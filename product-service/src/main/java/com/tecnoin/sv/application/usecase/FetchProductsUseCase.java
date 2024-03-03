package com.tecnoin.sv.application.usecase;

import com.tecnoin.sv.application.dto.ProductDto;
import java.util.List;

public interface FetchProductsUseCase {
    List<ProductDto> execute();
}