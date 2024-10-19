package com.example.enoca_javac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class PreviousOrder extends BaseEntity{
    @ManyToOne
    private Order order;

    private String productName;

    private double priceAtOrder;

    private int stockQuantity;
}
