package com.tecnoin.sv.domain.repository;


import com.tecnoin.sv.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Aquí puedes agregar métodos de consulta personalizados si es necesario
}
