package com.example.backend.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Shipment {
    private String noticol;
    private Boolean hazardous;
    private String destination;
    private String status;
    private String deliveryNote;

    private String startDate;
    private String endDate;
    private String actualDate;

    private HandlingUnit handlingUnit;

    public Shipment(String noticol, Boolean hazardous, String destination, String status, String startDate, String endDate, String deliveryNote) {

        this.noticol = noticol;
        this.hazardous = hazardous;
        this.destination = destination;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deliveryNote = deliveryNote;
    }

    public Shipment() {
    }
}