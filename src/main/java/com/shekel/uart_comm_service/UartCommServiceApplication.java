package com.shekel.uart_comm_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class UartCommServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UartCommServiceApplication.class, args);
		Logger.getLogger(UartCommServiceApplication.class.getName()).info("UartCommServiceApplication started :)");
	}

}
