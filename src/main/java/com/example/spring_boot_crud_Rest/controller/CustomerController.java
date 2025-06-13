package com.example.spring_boot_crud_Rest.controller;

import com.example.spring_boot_crud_Rest.entity.Customer;
import com.example.spring_boot_crud_Rest.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service=service;
    }
    
    @GetMapping
    public List<Customer> getAll(){
        return service.getAllCustomers();
    }
    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id){
        return service.getCustomerById(id);
    }


    @PostMapping
    public Customer create(@RequestBody Customer customer) {

        return service.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        return service.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCustomer(id);
    }

}
