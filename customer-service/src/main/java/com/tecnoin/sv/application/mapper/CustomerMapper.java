package com.tecnoin.sv.application.mapper;

import com.tecnoin.sv.application.dto.CustomerCreationDto;
import com.tecnoin.sv.application.dto.CustomerDto;
import com.tecnoin.sv.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto customerToCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setUserId(customer.getUserId());
        return customerDto;
    }
    public Customer customerDtoToCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getFirstName());
        customer.setUserId(customerDto.getUserId());
        return customer;
    }

    public Customer customerCreationDtoToCustomer(CustomerCreationDto customerCreationDto){
        Customer customer = new Customer();
        customer.setFirstName(customerCreationDto.getFirstName());
        customer.setLastName(customerCreationDto.getLastName());
        customer.setUserId(customerCreationDto.getUserId());
        return customer;
    }
}
