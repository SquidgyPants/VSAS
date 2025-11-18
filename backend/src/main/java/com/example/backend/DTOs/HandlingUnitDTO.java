package com.example.backend.DTOs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "handlingunitdto")
@Entity
public class HandlingUnitDTO {
    @Id
    private String id;
    private double weight;

    private double breadth;
    private double length;
    private double height;

    private double volume;
    private String type;

    private boolean stackable;

    private String noticol;
}
