package com.shekel.uart_comm_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SensorDataDto {
    private Long id;
    private double temperature;
    private double humidity;
}
