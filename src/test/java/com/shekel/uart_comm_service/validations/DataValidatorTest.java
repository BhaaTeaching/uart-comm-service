package com.shekel.uart_comm_service.validations;

import com.shekel.uart_comm_service.dto.SensorDataDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {
    private final DataValidator sensorValidator = new DataValidator();

    @Test
    void validateSensorData_ValidData_ShouldNotThrowException() {
        SensorDataDto validData = new SensorDataDto(1L, 25, 50);
        assertDoesNotThrow(() -> sensorValidator.validateSensorData(validData));
    }

    @Test
    void validateSensorData_TemperatureBelowZero_ShouldThrowException() {
        SensorDataDto invalidData = new SensorDataDto(1L,-1, 50);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                sensorValidator.validateSensorData(invalidData)
        );
        assertEquals("Temperature must be between 0 and 50 degrees.", exception.getMessage());
    }

    @Test
    void validateSensorData_TemperatureAboveFifty_ShouldThrowException() {
        SensorDataDto invalidData = new SensorDataDto(1L,51, 50);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                sensorValidator.validateSensorData(invalidData)
        );
        assertEquals("Temperature must be between 0 and 50 degrees.", exception.getMessage());
    }

    @Test
    void validateSensorData_HumidityBelowTwenty_ShouldThrowException() {
        SensorDataDto invalidData = new SensorDataDto(1L,25, 19);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                sensorValidator.validateSensorData(invalidData)
        );
        assertEquals("Humidity must be between 20 and 100 percent.", exception.getMessage());
    }

    @Test
    void validateSensorData_HumidityAboveHundred_ShouldThrowException() {
        SensorDataDto invalidData = new SensorDataDto(1L,25, 101);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                sensorValidator.validateSensorData(invalidData)
        );
        assertEquals("Humidity must be between 20 and 100 percent.", exception.getMessage());
    }
}