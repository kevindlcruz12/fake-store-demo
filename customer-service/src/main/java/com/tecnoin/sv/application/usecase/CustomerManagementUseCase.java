package com.tecnoin.sv.application.usecase;

import com.tecnoin.sv.application.dto.CustomerDto;
import com.tecnoin.sv.application.mapper.CustomerMapper;
import com.tecnoin.sv.domain.entity.Customer;
import com.tecnoin.sv.domain.service.CustomerDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerManagementUseCase {

    private final CustomerDomainService customerDomainService;
    private final CustomerMapper customerMapper;

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        Customer savedCustomer = customerDomainService.saveCustomer(customer);
        return customerMapper.customerToCustomerDto(savedCustomer);
    }

    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        customer.setId(id); // Asegurar que el ID es establecido para la actualización
        Customer updatedCustomer = customerDomainService.saveCustomer(customer);
        return customerMapper.customerToCustomerDto(updatedCustomer);
    }

    public CustomerDto findCustomerById(Long id) {
        return customerDomainService.findCustomerById(id)
                .map(customerMapper::customerToCustomerDto)
                .orElseThrow(() -> new RuntimeException("Customer not found")); // Considerar una excepción más específica
    }

    public List<CustomerDto> findAllCustomers() {
        return customerDomainService.findAllCustomers().stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    public void deleteCustomer(Long id) {
        customerDomainService.deleteCustomer(id);
    }
}
