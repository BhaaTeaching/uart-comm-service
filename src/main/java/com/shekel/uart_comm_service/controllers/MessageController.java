package com.shekel.uart_comm_service.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shekel.uart_comm_service.dto.SensorDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MessageController {
    private final ObjectMapper objectMapper;
    private final SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/message")
    @SendTo("/topic/response")
    public void handleMessage(String message) {
        log.info("Received message: {}", message);
    }

    public void sendUpdate(SensorDataDto data) {
        try {
            String jsonData = objectMapper.writeValueAsString(data);
            log.info("Broadcasting message to /topic/response: {}", jsonData);
            messagingTemplate.convertAndSend("/topic/response", jsonData);
            log.info("Broadcasting message  done to /topic/response: {}", jsonData);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("Error serializing data: ", jsonProcessingException);
        }
    }
}
