package com.example.enoca_javac.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Product extends BaseEntity {
    private long productId;
    private String name;
    private double price;
    private int stockQuantity;

    public boolean isAvailable(){
       return this.stockQuantity>0;
    }


}
