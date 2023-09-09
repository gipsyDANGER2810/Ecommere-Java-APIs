package com.product.product.service.repository;

import com.product.product.service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer>findByUsername(String username);

    @Query("SELECT c FROM Customer c JOIN FETCH c.reviews WHERE c.userId = :userId")
    Optional<Customer> findByIdWithReviews(@Param("userId") String userId);

}
