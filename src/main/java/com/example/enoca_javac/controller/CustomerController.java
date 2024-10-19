package com.example.enoca_javac.controller;


import com.example.enoca_javac.dto.CustomerDTO;
import com.example.enoca_javac.entity.Customer;
import com.example.enoca_javac.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.addCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    

}
