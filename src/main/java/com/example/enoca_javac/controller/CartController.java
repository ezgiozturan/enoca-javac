package com.example.enoca_javac.controller;

import com.example.enoca_javac.dto.CartDTO;
import com.example.enoca_javac.entity.Cart;
import com.example.enoca_javac.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCart(@PathVariable long customerId) {
        Cart cart = cartService.getCart(customerId);
        return ResponseEntity.ok(cart);
    }


    @PutMapping("/{cartId}")
    public ResponseEntity<Cart> updateCart(@PathVariable long cartId, @RequestBody CartDTO cartDTO) {
        Cart updatedCart = cartService.updateCart(cartId, cartDTO);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{cartId}/empty")
    public ResponseEntity<Cart> emptyCart(@PathVariable long cartId) {
        Cart cart = cartService.emptyCart(cartId);
        return ResponseEntity.ok(cart);
    }

}
