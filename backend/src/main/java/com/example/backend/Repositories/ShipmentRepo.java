package com.example.backend.Repositories;

import com.example.backend.DTOs.ShipmentDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepo extends CrudRepository<ShipmentDTO, String> {
}
