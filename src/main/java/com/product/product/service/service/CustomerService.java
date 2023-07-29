package com.product.product.service.service;

import com.product.product.service.model.Customer;
import com.product.product.service.model.Product;

import java.util.List;


public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomer();

    Customer getCustomerById(long id);

    Customer updateCustomer(Customer customer, long id);

    void deleteCustomer(long id);
}
