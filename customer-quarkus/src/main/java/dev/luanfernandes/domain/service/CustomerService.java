package dev.luanfernandes.domain.service;

import dev.luanfernandes.domain.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAllCustomers();

    CustomerDTO findustomerById(Long id);

    void createCustomer(CustomerDTO customerDTO);

    void updateCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomer(Long id);
}
