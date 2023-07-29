package com.product.product.service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
