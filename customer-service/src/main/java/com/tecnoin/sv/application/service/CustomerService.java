package com.tecnoin.sv.application.service;


import com.tecnoin.sv.application.dto.CustomerCreationDto;
import com.tecnoin.sv.application.dto.CustomerDto;
import com.tecnoin.sv.application.mapper.CustomerMapper;
import com.tecnoin.sv.domain.entity.Customer;
import com.tecnoin.sv.domain.service.CustomerDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerDomainService customerDomainService;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerDomainService customerDomainService, CustomerMapper customerMapper) {
        this.customerDomainService = customerDomainService;
        this.customerMapper = customerMapper;
    }

    public CustomerDto createOrUpdateCustomer(CustomerCreationDto customerDto) {
        Customer customer = customerMapper.customerCreationDtoToCustomer(customerDto);
        customer = customerDomainService.saveCustomer(customer);
        return customerMapper.customerToCustomerDto(customer);
    }

    public List<CustomerDto> getAllCustomers() {
        return customerDomainService.findAllCustomers().stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    public void deleteCustomer(Long id) {
        customerDomainService.deleteCustomer(id);
    }
}
