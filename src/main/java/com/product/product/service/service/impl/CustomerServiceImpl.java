package com.product.product.service.service.impl;

import com.product.product.service.exception.ResourceNotFoundException;
import com.product.product.service.model.Customer;
import com.product.product.service.model.LoginDTO;
import com.product.product.service.repository.CustomerRepository;
import com.product.product.service.repository.ReviewRepository;
import com.product.product.service.service.CustomerService;
import com.product.product.service.service.TokenService;
import lombok.AllArgsConstructor;

import org.hibernate.Hibernate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReviewRepository reviewRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenService tokenService;




    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(String id) {

        Customer customer = customerRepository.findByIdWithReviews(id).orElseThrow(() ->
                new ResourceNotFoundException("Customer", "Id", id));
////        System.out.println("JPQL RESULT : \n"+ customerRepository.findByIdWithReviews(id).toString());
//        if (customer != null) {
//            // Hibernate should automatically fetch the reviews for the customer
//            // because of the @OneToMany mapping.
//            // However, if the reviews are not being loaded, you can force the fetch like:
//            customer.getReviews().size();
//            System.out.println(customer.getReviews());
//        }
        return customer;
//        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
    }

    @Override
    public Customer updateCustomer(Customer customer, String id) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Customer", "Id", id));
        existingCustomer.setUsername(customer.getUsername());
//        existingCustomer.setLastName(customer.getLastName());
//        existingCustomer.setEmail(customer.getEmail());
//        existingCustomer.setPassword(customer.getPassword());
        customerRepository.save(existingCustomer);
        return existingCustomer;
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", id));
        customerRepository.deleteById(id);
    }


}



