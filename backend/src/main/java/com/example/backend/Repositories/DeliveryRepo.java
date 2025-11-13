package com.example.backend.Repositories;

import com.example.backend.DTOs.DeliveryDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends CrudRepository<DeliveryDTO, String> {
}
