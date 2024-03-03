package com.tecnoin.sv.application.mapper;

import com.tecnoin.sv.application.dto.ProductDto;
import com.tecnoin.sv.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());

        return productDto;
    }

    public Product toEntity(ProductDto dto) {
       Product product = new Product();
       product.setId(dto.getId());

       return product;
    }
}