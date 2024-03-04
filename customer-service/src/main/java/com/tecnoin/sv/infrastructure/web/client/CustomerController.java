package com.tecnoin.sv.infrastructure.web.client;

import com.tecnoin.sv.application.dto.CustomerCreationDto;
import com.tecnoin.sv.application.dto.CustomerDto;
import com.tecnoin.sv.application.service.CustomerService;
import com.tecnoin.sv.shared.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerApplicationService;

    public CustomerController(CustomerService customerApplicationService) {
        this.customerApplicationService = customerApplicationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createOrUpdateCustomer(@RequestBody CustomerCreationDto customerDto) {
        CustomerDto create = customerApplicationService.createOrUpdateCustomer(customerDto);
        return ResponseEntity.ok().body(ApiResponse.success(create));
    }


    @GetMapping
    public ResponseEntity<?>  getAllCustomers() {
        List<CustomerDto> customers = customerApplicationService.getAllCustomers();
        return ResponseEntity.ok().body(ApiResponse.success(customers));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        customerApplicationService.deleteCustomer(id);
    }
}
