package com.example.enoca_javac.service;

import com.example.enoca_javac.dto.CustomerDTO;
import com.example.enoca_javac.entity.Customer;
import com.example.enoca_javac.entity.Order;
import com.example.enoca_javac.repository.CustomerRepository;
import com.example.enoca_javac.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Customer addCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        return customerRepository.save(customer);
    };

    public List<Order> getAllOrdersForCustomer(long customerId){
        Optional<Customer> customer =customerRepository.findById(customerId);
        return customer.get().getOrders();
    };
}
