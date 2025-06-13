package com.example.spring_boot_crud_Rest.repository;

import com.example.spring_boot_crud_Rest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
