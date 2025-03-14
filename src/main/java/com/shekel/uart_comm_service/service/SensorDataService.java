package com.shekel.uart_comm_service.service;

import com.shekel.uart_comm_service.dto.SensorDataDto;
import com.shekel.uart_comm_service.exceptions.NoContentException;
import com.shekel.uart_comm_service.mapper.UartMapper;
import com.shekel.uart_comm_service.models.SensorData;
import com.shekel.uart_comm_service.repository.SensorDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class SensorDataService {
    private final UartMapper mapper;
    private final SensorDataRepository sensorDataRepository;

    public SensorDataDto findSensorData(Long id) {
        Optional<SensorData> sensorData = sensorDataRepository.findById(id);
        if (sensorData.isEmpty()) {
            throw new NoContentException();
        }
        return mapper.toSensorDataDto(sensorData.get());
    }


}
