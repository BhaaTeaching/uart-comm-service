package com.shekel.uart_comm_service.validations;

import com.shekel.uart_comm_service.dto.SensorDataDto;
import org.springframework.stereotype.Service;

@Service
public class DataValidator {
    public void validateSensorData(SensorDataDto sensorDataDto) {
        if (sensorDataDto.getTemperature() < 0 || sensorDataDto.getTemperature() > 50) {
            throw new IllegalArgumentException("Temperature must be between 0 and 50 degrees.");
        }

        if (sensorDataDto.getHumidity() < 20 || sensorDataDto.getHumidity() > 100) {
            throw new IllegalArgumentException("Humidity must be between 20 and 100 percent.");
        }
    }
}
