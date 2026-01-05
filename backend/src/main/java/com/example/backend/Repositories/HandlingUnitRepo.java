package com.example.backend.Repositories;

import com.example.backend.DTOs.HandlingUnitDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HandlingUnitRepo extends JpaRepository<HandlingUnitDTO, String>, QueryByExampleExecutor<HandlingUnitDTO>, CrudRepository<HandlingUnitDTO, String> {
    @Query("SELECT new HandlingUnitDTO(h.id, h.noticol, h.type, h.weight, h.breadth, h.length, h.height, h.stackable, h.volume) FROM HandlingUnitDTO h WHERE h.noticol = ?1")
    HandlingUnitDTO findByNoticol(String noticol);
}
