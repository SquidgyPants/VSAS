package com.example.backend.Repositories;

import com.example.backend.DTOs.ShipmentDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ShipmentRepo extends JpaRepository<ShipmentDTO, String>, QueryByExampleExecutor<ShipmentDTO>, CrudRepository<ShipmentDTO, String> {
}