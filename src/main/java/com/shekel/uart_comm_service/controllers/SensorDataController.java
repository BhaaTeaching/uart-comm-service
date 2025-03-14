package com.shekel.uart_comm_service.controllers;

import com.shekel.uart_comm_service.dto.SensorDataDto;
import com.shekel.uart_comm_service.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sensor-data")
@RequiredArgsConstructor
public class SensorDataController {
    private final SensorDataService sensorDataService;


    @GetMapping("/{id}")
    public SensorDataDto getSensorData(@PathVariable Long id) {
        return sensorDataService.findSensorData(id);
    }

}
