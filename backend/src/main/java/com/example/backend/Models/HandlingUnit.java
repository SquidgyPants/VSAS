package com.example.backend.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HandlingUnit {
    private String id;
    private double weight;
    private double breadth;
    private double length;
    private double height;
    private double volume;
    private String type;
    private boolean stackable;

    private List<Delivery> deliveries;
}
