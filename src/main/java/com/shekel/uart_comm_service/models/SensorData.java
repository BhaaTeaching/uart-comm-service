package com.shekel.uart_comm_service.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "uart_sim_db")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double temperature;

    private double humidity;
}

