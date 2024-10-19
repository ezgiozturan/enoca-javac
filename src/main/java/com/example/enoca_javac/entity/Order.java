package com.example.enoca_javac.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Order extends BaseEntity{
    @ManyToOne
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<PreviousOrder> orders = new ArrayList<>();

    private double totalPrice;


}
