package com.example.backend.Mappers;

import com.example.backend.DTOs.DeliveryDTO;
import com.example.backend.Models.Delivery;

public class DeliveryMapper {
    public static Delivery toEntity(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();
        delivery.setId(deliveryDTO.getId());
        delivery.setManufacturer(deliveryDTO.getManufacturer());
        delivery.setPrice(deliveryDTO.getPrice());
        delivery.setItemNumber(deliveryDTO.getItemNumber());
        delivery.setOrderNumber(deliveryDTO.getOrderNumber());
        delivery.setQuantity(deliveryDTO.getQuantity());
        return delivery;
    }

    public static DeliveryDTO toDTO(Delivery delivery) {
        DeliveryDTO deliveryDTO = new DeliveryDTO();
        deliveryDTO.setId(delivery.getId());
        deliveryDTO.setManufacturer(delivery.getManufacturer());
        deliveryDTO.setPrice(delivery.getPrice());
        deliveryDTO.setItemNumber(delivery.getItemNumber());
        deliveryDTO.setOrderNumber(delivery.getOrderNumber());
        deliveryDTO.setQuantity(delivery.getQuantity());
        return deliveryDTO;
    }
}
