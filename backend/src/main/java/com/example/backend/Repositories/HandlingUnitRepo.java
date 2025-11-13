package com.example.backend.Repositories;

import com.example.backend.DTOs.HandlingUnitDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandlingUnitRepo extends CrudRepository<HandlingUnitDTO, String> {
}
