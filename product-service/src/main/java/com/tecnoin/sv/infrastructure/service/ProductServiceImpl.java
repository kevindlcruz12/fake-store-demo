package com.tecnoin.sv.infrastructure.service;

import com.tecnoin.sv.application.dto.ProductDto;
import com.tecnoin.sv.application.service.ProductService;
import com.tecnoin.sv.infrastructure.web.client.FakeStoreApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final FakeStoreApiClient fakeStoreApiClient;

    @Autowired
    public ProductServiceImpl(FakeStoreApiClient fakeStoreApiClient) {
        this.fakeStoreApiClient = fakeStoreApiClient;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return fakeStoreApiClient.getProducts();
    }

    @Override
    public ProductDto getProductById(Long id) {
        return fakeStoreApiClient.getProductById(id);
    }
}