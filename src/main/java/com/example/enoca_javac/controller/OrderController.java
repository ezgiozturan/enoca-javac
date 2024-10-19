package com.example.enoca_javac.controller;


import com.example.enoca_javac.entity.Order;
import com.example.enoca_javac.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place/{customerId}")
    public ResponseEntity<Order> placeOrder(@PathVariable long customerId) {
        Order order = orderService.placeOrder(customerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

}
