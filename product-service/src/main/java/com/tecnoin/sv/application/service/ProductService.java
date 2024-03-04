package com.tecnoin.sv.application.service;

import com.tecnoin.sv.application.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final RestTemplate restTemplate;
    private final String apiUrl = "https://fakestoreapi.com/products";

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProductDto> getProducts() {
        ProductDto[] productArray = restTemplate.getForObject(apiUrl, ProductDto[].class);
        return Arrays.asList(productArray);
    }

    public ProductDto getProductById(Long id) {
        return restTemplate.getForObject(apiUrl + "/{id}", ProductDto.class, id);
    }
}