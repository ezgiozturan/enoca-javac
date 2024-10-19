package com.example.enoca_javac.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class Cart extends BaseEntity{

@Entity
public class Cart extends BaseEntity {
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    private double totalPrice = 0.0;

    public void addProduct(Product product) {
        products.add(product);
        calculateTotalPrice();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        calculateTotalPrice();
    }

    public void calculateTotalPrice() {
        totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}

