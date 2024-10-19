package com.example.enoca_javac.service;

import com.example.enoca_javac.dto.CartDTO;
import com.example.enoca_javac.entity.Cart;
import com.example.enoca_javac.entity.Product;
import com.example.enoca_javac.exception.ResourceNotFoundException;
import com.example.enoca_javac.repository.CartRepository;
import com.example.enoca_javac.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart getCart(long customerId){
        return cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart bulunamadı"));
    };

    public Cart updateCart(long cartId, CartDTO cartDTO){
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart bulunamadı"));

        cart.setProducts(cartDTO.getProducts().stream().map(dto -> {
            Product product = productRepository.findById(dto.getProductId())
             .orElseThrow(() -> new ResourceNotFoundException("Ürün bulunamadı"));
            return product;
        }).collect(Collectors.toList()));
        cart.calculateTotalPrice();
        return cartRepository.save(cart);

    };

    public Cart emptyCart(long cartId){
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart bulunamadı"));

        cart.getProducts().clear();
        cart.calculateTotalPrice();

        return cartRepository.save(cart);
    };


    public  Cart addProductToCart(long cartId, long productId){
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart bulunamadı"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Ürün bulunamadı"));


        if (!product.isAvailable()) {
            throw new IllegalStateException("Ürün stoğu kalmamıştır");
        }

        cart.addProduct(product);
        product.setStockQuantity(product.getStockQuantity() - 1);

        return cartRepository.save(cart);

    };

    public Cart removeProductFromCart(long cartId, long productId){
        Cart cart = cartRepository.findById(cartId)
               .orElseThrow(() -> new ResourceNotFoundException("Cart bulunamadı"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Ürün bulunamadı"));


        cart.removeProduct(product);
        return cartRepository.save(cart);
    };
}
