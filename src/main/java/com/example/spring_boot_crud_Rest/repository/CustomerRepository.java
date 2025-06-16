package com.example.spring_boot_crud_Rest.repository;

import com.example.spring_boot_crud_Rest.entity.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByBookingDate(LocalDate bookingDate);
    Optional<Customer> findByName(String name);
}

