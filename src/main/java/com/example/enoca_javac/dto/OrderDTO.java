package com.example.enoca_javac.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private long id;
    private long customerId;
    private List<PreviousOrderDTO> previousOrderDTOS;
    private double totalPrice;
}
