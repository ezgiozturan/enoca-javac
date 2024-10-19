package com.example.enoca_javac.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreviousOrderDTO {
    private String productName;
    private double priceAtOrder;
    private int quantity;
}
