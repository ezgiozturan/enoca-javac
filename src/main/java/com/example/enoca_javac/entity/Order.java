package com.example.enoca_javac.entity;

public class Order {
import java.util.ArrayList;
import java.util.List;

public class Order extends BaseEntity{
    private Customer customer;
    
    private List<PreviousOrder> orders = new ArrayList<>();

    private double totalPrice;
}
