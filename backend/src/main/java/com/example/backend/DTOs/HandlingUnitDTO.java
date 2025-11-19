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

    public HandlingUnitDTO() {

    }

    public HandlingUnitDTO(String id, String noticol, String type, double weight, double breadth, double length, double height, boolean stackable, double volume) {
        this.id = id;
        this.noticol = noticol;
        this.type = type;
        this.weight = weight;
        this.breadth = breadth;
        this.length = length;
        this.height = height;
        this.stackable = stackable;
        this.volume = volume;
    }
}
