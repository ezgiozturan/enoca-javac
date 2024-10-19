package com.example.enoca_javac.entity;

public class Order {
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Order extends BaseEntity{
    @ManyToOne
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<PreviousOrder> orders = new ArrayList<>();

    private double totalPrice;
}
