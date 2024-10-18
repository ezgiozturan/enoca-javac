package com.example.enoca_javac.entity;

public class Product extends BaseEntity {
    private String name;
    private double price;
    private int stockQuantity;

    private boolean isAvailable(){
       return this.stockQuantity>0;
    }
}
