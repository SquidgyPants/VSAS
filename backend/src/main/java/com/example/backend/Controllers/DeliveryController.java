package com.example.backend.Controllers;

import com.example.backend.Services.DeliveryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    private DeliveryService deliveryService;
}
