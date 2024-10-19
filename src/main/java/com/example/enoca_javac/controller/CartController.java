package com.example.enoca_javac.controller;

import com.example.enoca_javac.entity.Cart;
import com.example.enoca_javac.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCart(@PathVariable long customerId) {
        Cart cart = cartService.getCart(customerId);
        return ResponseEntity.ok(cart);
    }



}
