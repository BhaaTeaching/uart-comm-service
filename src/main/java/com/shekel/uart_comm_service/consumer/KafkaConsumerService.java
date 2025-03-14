package com.shekel.uart_comm_service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shekel.uart_comm_service.controllers.MessageController;
import com.shekel.uart_comm_service.dto.SensorData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.lang.runtime.ObjectMethods;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaConsumerService {
    private final ObjectMapper objectMapper;
    private final MessageController messageController;

    @KafkaListener(topics = "uart.sim.data", groupId = "uart-group")
    public void listen(String message) throws JsonProcessingException {
        System.out.println("Received Message in UART Consumer: " + message);
        SensorData sensorData = objectMapper.readValue(message, SensorData.class);
        log.info("sensorData: {}",sensorData);
        messageController.sendUpdate(sensorData);
        log.info("sensorData: {}",sensorData);
    }
}
