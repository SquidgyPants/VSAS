package com.example.backend.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Delivery {
    private String id;
    private String orderNumber;
    private int quantity;
    private double price;
    private String itemNumber;
    private String manufacturer;
}
