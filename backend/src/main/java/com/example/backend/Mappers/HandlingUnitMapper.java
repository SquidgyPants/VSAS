package com.example.backend.Mappers;

import com.example.backend.DTOs.HandlingUnitDTO;
import com.example.backend.Models.HandlingUnit;

import java.util.ArrayList;
import java.util.UUID;

public class HandlingUnitMapper {
    public static HandlingUnit toEntity(HandlingUnitDTO dto) {
        HandlingUnit handlingUnit = new HandlingUnit();
        handlingUnit.setId(UUID.fromString(dto.getId()));
        handlingUnit.setBreadth(dto.getBreadth());
        handlingUnit.setHeight(dto.getHeight());
        handlingUnit.setWeight(dto.getWeight());
        handlingUnit.setLength(dto.getLength());
        handlingUnit.setStackable(dto.isStackable());
        handlingUnit.setType(dto.getType());
        handlingUnit.setVolume(dto.getVolume());
        handlingUnit.setDeliveries(new ArrayList<>());

        return handlingUnit;
    }

    public static HandlingUnitDTO toDTO(HandlingUnit handlingUnit) {
        HandlingUnitDTO dto = new HandlingUnitDTO();
        dto.setId(handlingUnit.getId().toString());
        dto.setBreadth(handlingUnit.getBreadth());
        dto.setHeight(handlingUnit.getHeight());
        dto.setWeight(handlingUnit.getWeight());
        dto.setLength(handlingUnit.getLength());
        dto.setStackable(handlingUnit.isStackable());
        dto.setType(handlingUnit.getType());
        dto.setVolume(handlingUnit.getVolume());

        return dto;
    }
}
