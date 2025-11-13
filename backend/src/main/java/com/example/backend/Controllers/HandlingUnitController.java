package com.example.backend.Controllers;

import com.example.backend.Services.HandlingUnitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/handling-unit")
public class HandlingUnitController {
    private HandlingUnitService handlingUnitService;
}
