package com.tecnoin.sv.domain.service;

import com.tecnoin.sv.domain.entity.Customer;
import com.tecnoin.sv.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerDomainService {

    private final CustomerRepository customerRepository;

    public CustomerDomainService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        // Aquí puedes añadir cualquier lógica de negocio antes de guardar el cliente
        return customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerById(Long id) {
        // Puedes añadir lógica adicional antes o después de buscar al cliente, si es necesario
        return customerRepository.findById(id);
    }

    public List<Customer> findAllCustomers() {
        // Aquí también puedes añadir lógica adicional si necesitas procesar los datos de los clientes de alguna manera específica
        return customerRepository.findAll();
    }

    public void deleteCustomer(Long id) {
        // Antes de eliminar, puedes incluir comprobaciones o lógica de negocio, por ejemplo, verificar si el cliente puede ser eliminado
        customerRepository.deleteById(id);
    }
}
