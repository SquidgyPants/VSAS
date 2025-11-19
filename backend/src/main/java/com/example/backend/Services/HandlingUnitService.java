package com.example.backend.Services;

import com.example.backend.DTOs.HandlingUnitDTO;
import com.example.backend.Mappers.HandlingUnitMapper;
import com.example.backend.Models.HandlingUnit;
import com.example.backend.Repositories.HandlingUnitRepo;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandlingUnitService {
    private final HandlingUnitRepo handlingUnitRepo;
    private DeliveryService deliveryService;

    public HandlingUnitService(HandlingUnitRepo handlingUnitRepo, DeliveryService deliveryService) {
        this.handlingUnitRepo = handlingUnitRepo;
        this.deliveryService = deliveryService;
    }

    public HandlingUnit getHandlingUnitByShipmentId(String noticol) {
        HandlingUnit handlingUnit = HandlingUnitMapper.toEntity(handlingUnitRepo.findByNoticol(noticol));
        handlingUnit.setDeliveries(deliveryService.getDeliveriesByHandlingUnitId(handlingUnit.getId().toString()));
        return handlingUnit;
    }
}
