package com.example.backend.DTOs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "deliverydto")
@Entity
public class DeliveryDTO {
    @Id
    private String id;
    private String orderNumber;

    private int quantity;
    private double price;
    private String manufacturer;

    private String itemNumber;

    @ManyToOne
    @JoinColumn(name = "handlingunitid")
    private HandlingUnitDTO handlingUnit;

    public DeliveryDTO() {

    }

    public DeliveryDTO(String id, String manufacturer, double price,  String itemNumber, String orderNumber, int quantity, HandlingUnitDTO handlingUnit) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.price = price;
        this.itemNumber = itemNumber;
        this.orderNumber = orderNumber;
        this.quantity = quantity;
        this.handlingUnit = handlingUnit;
    }
}
