package com.example.enoca_javac.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private long id;
    private String name;
    private double price;
    private int stockQuantity;
}
