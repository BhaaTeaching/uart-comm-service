package com.shekel.uart_comm_service.service;

import com.shekel.uart_comm_service.dto.SensorDataDto;
import com.shekel.uart_comm_service.exceptions.NoContentException;
import com.shekel.uart_comm_service.mapper.UartMapper;
import com.shekel.uart_comm_service.models.SensorData;
import com.shekel.uart_comm_service.repository.SensorDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SensorDataServiceTest {
    @Mock
    private SensorDataRepository sensorDataRepository;

    @Mock
    private UartMapper mapper;

    @InjectMocks
    private SensorDataService sensorDataService;

    @Test
    void findSensorData_ExistingId_ShouldReturnSensorDataDto() {
        Long sensorId = 1L;
        SensorData mockSensorData = new SensorData(sensorId, 25, 50);
        SensorDataDto mockSensorDataDto = new SensorDataDto(sensorId, 25, 50);

        when(sensorDataRepository.findById(sensorId)).thenReturn(Optional.of(mockSensorData));
        when(mapper.toSensorDataDto(mockSensorData)).thenReturn(mockSensorDataDto);

        SensorDataDto result = sensorDataService.findSensorData(sensorId);

        assertNotNull(result);
        assertEquals(mockSensorDataDto.getTemperature(), result.getTemperature());
        assertEquals(mockSensorDataDto.getHumidity(), result.getHumidity());

        verify(sensorDataRepository).findById(sensorId);
        verify(mapper).toSensorDataDto(mockSensorData);
    }

    @Test
    void findSensorData_NonExistentId_ShouldThrowNoContentException() {
        Long sensorId = 2L;
        when(sensorDataRepository.findById(sensorId)).thenReturn(Optional.empty());

        assertThrows(NoContentException.class, () -> sensorDataService.findSensorData(sensorId));

        verify(sensorDataRepository).findById(sensorId);
        verifyNoInteractions(mapper);
    }
}