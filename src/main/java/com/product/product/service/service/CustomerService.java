package com.product.product.service.service;

import com.product.product.service.model.Customer;
import com.product.product.service.model.LoginDTO;
import com.product.product.service.model.Product;
import java.util.List;

public interface CustomerService  {


    List<Customer> getAllCustomer();

    Customer getCustomerById(String id);

    Customer updateCustomer(Customer customer, String id);

    void deleteCustomer(String id);


}
