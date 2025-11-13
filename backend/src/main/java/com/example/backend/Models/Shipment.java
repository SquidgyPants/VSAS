package com.example.backend.Models;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Shipment {
    private String id;
    private String noticol;
    private boolean hazardous;
    private String destination;
    private String status;

    private List<HandlingUnit> handlingUnits;
}