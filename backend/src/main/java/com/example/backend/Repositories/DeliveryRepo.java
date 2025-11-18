package com.example.backend.Repositories;

import com.example.backend.DTOs.DeliveryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends JpaRepository<DeliveryDTO, String>, QueryByExampleExecutor<DeliveryDTO>, CrudRepository<DeliveryDTO, String> {
}
