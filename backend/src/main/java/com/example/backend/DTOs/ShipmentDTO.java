package com.example.backend.DTOs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "shipmentdto")
@Entity
public class ShipmentDTO {
    @Id
    private String noticol;

    private Boolean hazardous;
    private String status;
    private LocalDate date;
    private String deliveryNote;

    private String destination;
}
