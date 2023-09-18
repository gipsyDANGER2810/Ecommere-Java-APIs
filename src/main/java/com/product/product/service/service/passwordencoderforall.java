package com.product.product.service.service;

import com.product.product.service.model.Customer;
import com.product.product.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class passwordencoderforall {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    public void encodeExistingPasswords() {
        List<Customer> allUsers = customerRepository.findAll();

        // Process only the first 10 users
        List<Customer> usersToProcess = allUsers.stream().limit(10).collect(Collectors.toList());

        for (Customer user : usersToProcess) {
            String password = user.getPassword();

            // Check if the password starts with "{bcrypt}"
            if (!password.startsWith("{bcrypt}")) {
                String encodedPassword = passwordEncoder.encode(password);
                user.setPassword(encodedPassword);
                customerRepository.save(user);
            }
        }
    }
}

