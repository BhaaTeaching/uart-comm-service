package com.shekel.uart_comm_service.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
@Slf4j
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        log.info("Configuring message broker...");
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        log.info("Registering WebSocket endpoint: /ws-endpoint");

        registry.addEndpoint("/ws-endpoint")
                .setAllowedOriginPatterns("*")
                .withSockJS();

        registry.addEndpoint("/ws-endpoint")
                .setAllowedOriginPatterns("*");
    }
}

