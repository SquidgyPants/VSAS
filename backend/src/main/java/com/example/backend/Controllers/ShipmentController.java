package com.example.backend.Controllers;

import com.example.backend.Models.Shipment;
import com.example.backend.Services.ShipmentService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
                                                          @RequestParam(required = false) String endDate,
                                                          @RequestParam(required = false) String deliveryNote) {
        Shipment exampleShipment = new Shipment(
                noticol != null && !noticol.isBlank() ? noticol : null,
                hazardous,
                destination != null && !destination.isBlank() ? destination : null,
                status != null && !status.isBlank() ? status : null,
                startDate != null && !startDate.isBlank() ? startDate : null,
                endDate != null && !endDate.isBlank() ? endDate : null,
                deliveryNote != null && !deliveryNote.isBlank() ? deliveryNote : null
        );

        List<Shipment> shipments = shipmentService.SearchShipments(exampleShipment);
        if (shipments == null || !shipments.iterator().hasNext()) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(shipments);
        }
    }

    @GetMapping("/getShipmentById")
    public ResponseEntity<Shipment> getShipmentById(@RequestParam String noticol) {
        Shipment shipment = shipmentService.GetShipmentById(noticol);
        if (shipment == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(shipment);
        }
    }

    @PostMapping("/exportToExcel")
    public void exportToExcel(HttpServletResponse response, @RequestBody Shipment shipment) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=\"" + shipment.getNoticol() + "_" + shipment.getActualDate() + ".xlsx\"";
        response.setHeader(headerKey, headerValue);
        shipmentService.ExportShipmentToExcel(response, shipment);
    }
}
