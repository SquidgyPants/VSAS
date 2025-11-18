package com.example.backend.Controllers;

import com.example.backend.Models.Shipment;
import com.example.backend.Services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {
    private ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping("/searchShipments")
    public ResponseEntity<List<Shipment>> searchShipments(@RequestParam(required = false) String noticol,
                                                          @RequestParam(required = false) Boolean hazardous,
                                                          @RequestParam(required = false) String status,
                                                          @RequestParam(required = false) String destination,
                                                          @RequestParam(required = false) String startDate,
                                                          @RequestParam(required = false) String endDate) {
        Shipment exampleShipment = new Shipment(noticol, hazardous, destination, status, startDate, endDate);
        if (new Shipment() == exampleShipment) {
//            List<Shipment> shipments = shipmentService.SearchWithEmpty(exampleShipment);
            return null;
        }
        else {
            List<Shipment> shipments = shipmentService.SearchShipments(exampleShipment);
            if (shipments == null || !shipments.iterator().hasNext()) {
                return ResponseEntity.noContent().build();
            }
            else {
                return ResponseEntity.ok(shipments);
            }
        }
    }
}
