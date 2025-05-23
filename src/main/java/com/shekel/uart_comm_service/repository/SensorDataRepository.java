package com.shekel.uart_comm_service.repository;

import com.shekel.uart_comm_service.models.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
}
