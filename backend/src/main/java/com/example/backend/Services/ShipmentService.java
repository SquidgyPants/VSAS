package com.example.backend.Services;

import com.example.backend.Configs.ExcelExportUtils;
import com.example.backend.DTOs.HandlingUnitDTO;
import com.example.backend.DTOs.ShipmentDTO;
import com.example.backend.Mappers.DeliveryMapper;
import com.example.backend.Mappers.HandlingUnitMapper;
import com.example.backend.Mappers.ShipmentMapper;
import com.example.backend.Models.HandlingUnit;
import com.example.backend.Models.Shipment;
import com.example.backend.Repositories.DeliveryRepo;
import com.example.backend.Repositories.HandlingUnitRepo;
import com.example.backend.Repositories.ShipmentRepo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class ShipmentService {
    private final HandlingUnitRepo huRepo;
    private ShipmentRepo repo;
    private DeliveryRepo deRepo;

    public ShipmentService(HandlingUnitRepo _hurepo, ShipmentRepo _repo, DeliveryRepo deliveryRepo) {
        this.huRepo = _hurepo;
        this.repo = _repo;
        this.deRepo = deliveryRepo;
    }

    public List<Shipment> SearchShipments(Shipment exampleShipment) {
        Example<ShipmentDTO> example = Example.of(ShipmentMapper.toDto(exampleShipment));
        List<ShipmentDTO> shipmentDTOs = repo.findAll(example);

        List<ShipmentDTO> filtered = new ArrayList<>();
        for (ShipmentDTO dto : shipmentDTOs) {
                 if (exampleShipment.getStartDate() == null && exampleShipment.getEndDate() == null) {
                filtered.add(dto);
                continue;
            }
            if (exampleShipment.getStartDate() != null && dto.getDate().isBefore(LocalDate.parse(exampleShipment.getStartDate()))) continue;
            if (exampleShipment.getEndDate() != null && dto.getDate().isAfter(LocalDate.parse(exampleShipment.getEndDate()))) continue;
            filtered.add(dto);
        }
        if (filtered.isEmpty()) return null;
        List<Shipment> shipments = ShipmentMapper.toEntityList(filtered);
        for (Shipment shipment : shipments) {
            HandlingUnit hu = HandlingUnitMapper.toEntity(huRepo.findByNoticol(shipment.getNoticol()));
            hu.setDeliveries(DeliveryMapper.toEntityList(deRepo.findDeliveriesByHandlingunitid(hu.getId().toString())));
            shipment.setHandlingUnit(hu);
        }
        if (shipments == null || !shipments.iterator().hasNext()) {
            return null;
        }
        else {
            return shipments;
        }
    }

    public Shipment GetShipmentById(String noticol) {
        ShipmentDTO shipmentDTO = repo.findById(noticol).orElse(null);
        if (shipmentDTO == null) {
            return null;
        }
        Shipment shipment = ShipmentMapper.toEntity(shipmentDTO);
        HandlingUnit hu = HandlingUnitMapper.toEntity(huRepo.findByNoticol(shipment.getNoticol()));
        hu.setDeliveries(DeliveryMapper.toEntityList(deRepo.findDeliveriesByHandlingunitid(hu.getId().toString())));
        shipment.setHandlingUnit(hu);
        return shipment;
    }

    public Shipment ExportShipmentToExcel(HttpServletResponse response, Shipment shipment) throws IOException {
        ExcelExportUtils exportUtils = new ExcelExportUtils(shipment);
        exportUtils.exportDataToExcel(response, shipment);
        return shipment;
    }
}
