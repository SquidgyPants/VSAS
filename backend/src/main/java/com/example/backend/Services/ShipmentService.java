package com.example.backend.Services;

import com.example.backend.DTOs.HandlingUnitDTO;
import com.example.backend.DTOs.ShipmentDTO;
import com.example.backend.Mappers.HandlingUnitMapper;
import com.example.backend.Mappers.ShipmentMapper;
import com.example.backend.Models.Shipment;
import com.example.backend.Repositories.HandlingUnitRepo;
import com.example.backend.Repositories.ShipmentRepo;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipmentService {
    private final HandlingUnitRepo huRepo;
    private ShipmentRepo repo;

    public ShipmentService(HandlingUnitRepo _hurepo, ShipmentRepo _repo) {
        this.huRepo = _hurepo;
        this.repo = _repo;
    }

    public List<Shipment> SearchShipments(Shipment exampleShipment) {
        Example<ShipmentDTO> example = Example.of(ShipmentMapper.toDto(exampleShipment));
        List<ShipmentDTO> shipmentDTOs = repo.findAll(example);

        List<ShipmentDTO> filtered = new ArrayList<>();
        for (ShipmentDTO shipmentDTO : shipmentDTOs) {
            if (exampleShipment.getStartDate() == null)
        }

        List<Shipment> shipments = ShipmentMapper.toEntityList(shipmentDTOs);
        for (Shipment shipment : shipments) {
            shipment.setHandlingUnit(HandlingUnitMapper.toEntity(huRepo.findById(shipment.getNoticol()).orElse(new HandlingUnitDTO())));
        }
        if (shipments == null || !shipments.iterator().hasNext()) {
            return null;
        }
        else {
            return shipments;
        }
    }
}
