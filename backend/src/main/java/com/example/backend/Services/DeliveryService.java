package com.example.backend.Services;

import com.example.backend.Mappers.DeliveryMapper;
import com.example.backend.Models.Delivery;
import com.example.backend.Repositories.DeliveryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    private final DeliveryRepo repo;

    public DeliveryService(DeliveryRepo _repo) {
        this.repo = _repo;
    }

    public List<Delivery> getDeliveriesByHandlingUnitId(String handlingunitid) {
        return DeliveryMapper.toEntityList(repo.findDeliveriesByHandlingunitid(handlingunitid));
    }
}
