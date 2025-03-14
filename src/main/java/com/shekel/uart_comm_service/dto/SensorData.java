package com.shekel.uart_comm_service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SensorData implements Serializable {
    private Long id;
    private double temperature;
    private double humidity;
}
