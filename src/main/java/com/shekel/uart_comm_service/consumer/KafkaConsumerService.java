package com.shekel.uart_comm_service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shekel.uart_comm_service.controllers.MessageController;
import com.shekel.uart_comm_service.dto.SensorDataDto;
import com.shekel.uart_comm_service.validations.DataValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaConsumerService {
    private final ObjectMapper objectMapper;
    private final MessageController messageController;
    private final DataValidator validateSensorData;

    @KafkaListener(topics = "uart.sim.data", groupId = "uart-group")
    public void listen(String message) throws JsonProcessingException {
        log.info("Received Message in UART Consumer: {}", message);
        SensorDataDto sensorDataDto = objectMapper.readValue(message, SensorDataDto.class);
        validateSensorData.validateSensorData(sensorDataDto);
        log.debug("sensorData: {}", sensorDataDto);
        messageController.sendUpdate(sensorDataDto);
        log.info("sensorData sent to client: {}", sensorDataDto);
    }
}
