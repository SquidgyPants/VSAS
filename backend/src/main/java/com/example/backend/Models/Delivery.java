package com.example.backend.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Delivery {
    private UUID id;
    private String orderNumber;
    private int quantity;
    private double price;
    private String itemNumber;
    private String manufacturer;
}
