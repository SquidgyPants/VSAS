package com.example.backend.Mappers;

import com.example.backend.DTOs.ShipmentDTO;
import com.example.backend.Models.Shipment;

import java.util.ArrayList;

public class ShipmentMapper {
    public static Shipment toEntity(ShipmentDTO dto) {
        Shipment shipment = new Shipment();
        shipment.setId(dto.getId());
        shipment.setNoticol(dto.getNoticol());
        shipment.setDestination(dto.getDestination());
        shipment.setHazardous(dto.isHazardous());
        shipment.setStatus(dto.getStatus());
        shipment.setHandlingUnits(new ArrayList<>());

        return shipment;
    }

    public static ShipmentDTO toDto(Shipment shipment) {
        ShipmentDTO dto = new ShipmentDTO();
        dto.setId(shipment.getId());
        dto.setNoticol(shipment.getNoticol());
        dto.setDestination(shipment.getDestination());
        dto.setHazardous(shipment.isHazardous());
        dto.setStatus(shipment.getStatus());

        return dto;
    }
}
