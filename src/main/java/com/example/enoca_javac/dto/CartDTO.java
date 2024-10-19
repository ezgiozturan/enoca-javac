package com.example.enoca_javac.dto;

import com.example.enoca_javac.entity.PreviousOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDTO {
    private long cartId;
    private List<ProductDTO> products;
    private double totalPrice;
}
