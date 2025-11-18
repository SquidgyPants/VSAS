package com.example.backend.DTOs;

import com.example.backend.Models.HandlingUnit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name = "shipmentdto")
@Entity
public class ShipmentDTO {
    @Id
    private String noticol;

    private Boolean hazardous;
    private String status;
    private Date date;

    private String destination;
}
