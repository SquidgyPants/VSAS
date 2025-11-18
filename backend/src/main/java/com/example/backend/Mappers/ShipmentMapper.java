package com.example.backend.Mappers;

import com.example.backend.DTOs.ShipmentDTO;
import com.example.backend.Models.HandlingUnit;
import com.example.backend.Models.Shipment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

public class ShipmentMapper {
    public static Shipment toEntity(ShipmentDTO dto) {
        Shipment shipment = new Shipment();
        shipment.setNoticol(dto.getNoticol());
        shipment.setDestination(dto.getDestination());
        shipment.setHazardous(dto.getHazardous());
        shipment.setStatus(dto.getStatus());
        shipment.setHandlingUnit(new HandlingUnit());

        return shipment;
    }

    public static ShipmentDTO toDto(Shipment shipment) {
        ShipmentDTO dto = new ShipmentDTO();
        dto.setNoticol(shipment.getNoticol());
        dto.setDestination(shipment.getDestination());
        dto.setHazardous(shipment.getHazardous());
        dto.setStatus(shipment.getStatus());
        return dto;
    }

    public static List<Shipment> toEntityList(List<ShipmentDTO> shipmentDTOs) {
        if (shipmentDTOs == null) {
            return new ArrayList<>();
        }
        return shipmentDTOs.stream()
                .map(ShipmentMapper::toEntity)
                .toList();
    }
}
