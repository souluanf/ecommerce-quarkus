package dev.luanfernandes.infrastructure.implementation;

import dev.luanfernandes.domain.dto.CustomerDTO;
import dev.luanfernandes.domain.service.CustomerService;
import dev.luanfernandes.infrastructure.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {
    @Inject
    CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerDTO::new).toList();
    }

    @Override
    public CustomerDTO findustomerById(Long id) {
        return new CustomerDTO(customerRepository.findById(id));
    }

    @Override
    @Transactional
    public void createCustomer(CustomerDTO customerDTO){
        customerRepository.persist(customerDTO.toEntity());
    }

    @Override
    @Transactional
    public void updateCustomer(Long id, CustomerDTO customerDTO){
        var obj = customerRepository.findById(id);
        obj.setAddress(customerDTO.getAddress());
        obj.setAge(customerDTO.getAge());
        obj.setEmail(customerDTO.getEmail());
        obj.setName(customerDTO.getName());
        obj.setPhone(customerDTO.getPhone());
        customerRepository.persist(obj);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
