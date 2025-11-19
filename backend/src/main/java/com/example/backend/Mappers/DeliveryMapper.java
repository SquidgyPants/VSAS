package com.example.backend.Mappers;

import com.example.backend.DTOs.DeliveryDTO;
import com.example.backend.Models.Delivery;

import java.util.List;
import java.util.UUID;

public class DeliveryMapper {
    public static Delivery toEntity(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();
        delivery.setId(UUID.fromString(deliveryDTO.getId()));
        delivery.setManufacturer(deliveryDTO.getManufacturer());
        delivery.setPrice(deliveryDTO.getPrice());
        delivery.setItemNumber(deliveryDTO.getItemNumber());
        delivery.setOrderNumber(deliveryDTO.getOrderNumber());
        delivery.setQuantity(deliveryDTO.getQuantity());
        return delivery;
    }

    public static DeliveryDTO toDTO(Delivery delivery) {
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        deliveryDTO.setId(delivery.getId().toString());
        deliveryDTO.setManufacturer(delivery.getManufacturer());
        deliveryDTO.setPrice(delivery.getPrice());
        deliveryDTO.setItemNumber(delivery.getItemNumber());
        deliveryDTO.setOrderNumber(delivery.getOrderNumber());
        deliveryDTO.setQuantity(delivery.getQuantity());
        return deliveryDTO;
    }

    public static List<Delivery> toEntityList(List<DeliveryDTO> dtoList) {
        return dtoList.stream()
                .map(DeliveryMapper::toEntity)
                .toList();
    }
}
