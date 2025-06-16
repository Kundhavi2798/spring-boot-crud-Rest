package com.example.spring_boot_crud_Rest.service;

import com.example.spring_boot_crud_Rest.entity.Customer;
import com.example.spring_boot_crud_Rest.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.example.spring_boot_crud_Rest.exception.SlotUnavailableException;
import com.example.spring_boot_crud_Rest.exception.NameAlreadyExistsException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {

        Optional<Customer> existingBooking = customerRepository.findByBookingDate(customer.getBookingDate());
         if (existingBooking.isPresent()) {
throw new SlotUnavailableException("No slot available at this time.");
    }
        Optional<Customer> existingName = customerRepository.findByName(customer.getName());
    
     if (existingName.isPresent()) {
throw new NameAlreadyExistsException("The name of the customer already exisit.");
    }
    
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) return null;

        Customer existing = optionalCustomer.get();
        existing.setName(updatedCustomer.getName());
        existing.setEmail(updatedCustomer.getEmail());
        existing.setPhone(updatedCustomer.getPhone());
        existing.setBookingDate(updatedCustomer.getBookingDate());

        return customerRepository.save(existing);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
