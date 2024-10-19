package com.example.enoca_javac.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private List<ProductDTO> products;
    private double totalPrice;
}
