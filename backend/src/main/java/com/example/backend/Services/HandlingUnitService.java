package com.example.backend.Services;

import com.example.backend.DTOs.HandlingUnitDTO;
import com.example.backend.Mappers.HandlingUnitMapper;
import com.example.backend.Models.HandlingUnit;
import com.example.backend.Repositories.HandlingUnitRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandlingUnitService {
    private final HandlingUnitRepo handlingUnitRepo;

    public HandlingUnitService(HandlingUnitRepo handlingUnitRepo) {
        this.handlingUnitRepo = handlingUnitRepo;
    }

    public HandlingUnit getHandlingUnitByShipmentId(String shipmentId) {
        return HandlingUnitMapper.toEntity(
                handlingUnitRepo.findById(shipmentId).orElse(null)
        );
    }
}
