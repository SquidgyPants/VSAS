package com.example.backend.Repositories;

import com.example.backend.DTOs.DeliveryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepo extends JpaRepository<DeliveryDTO, String>, QueryByExampleExecutor<DeliveryDTO>, CrudRepository<DeliveryDTO, String> {
    @Query("SELECT new DeliveryDTO(d.id, d.manufacturer, d.price, d.itemNumber, d.orderNumber, d.quantity, new HandlingUnitDTO(h.id, h.noticol, h.type, h.weight, h.breadth, h.length, h.height, h.stackable, h.volume)) " +
            "FROM DeliveryDTO d " +
            "JOIN d.handlingUnit h " +
            "WHERE h.id = ?1")
    List<DeliveryDTO> findDeliveriesByHandlingunitid(String handlingunitid);
}
