package com.tecnoin.sv.infrastructure.web.client;

import com.tecnoin.sv.application.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "fakeStoreClient", url = "https://fakestoreapi.com")
public interface FakeStoreApiClient {

    @GetMapping("/products")
    List<ProductDto> getProducts();

    @GetMapping("/products/{id}")
    ProductDto getProductById(@PathVariable("id") Long id);
}