package com.product.product.service.service.impl;

import com.product.product.service.exception.ResourceNotFoundException;
import com.product.product.service.model.Customer;
import com.product.product.service.repository.CustomerRepository;
import com.product.product.service.repository.ProductRepository;
import com.product.product.service.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Customer","Id",id));
    }

    @Override
    public Customer updateCustomer(Customer customer, long id) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow( ()
                -> new ResourceNotFoundException("Customer","Id",id));
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPassword(customer.getPassword());
        customerRepository.save(existingCustomer);
        return existingCustomer;
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Customer","Id",id));
        customerRepository.deleteById(id);
    }
}
