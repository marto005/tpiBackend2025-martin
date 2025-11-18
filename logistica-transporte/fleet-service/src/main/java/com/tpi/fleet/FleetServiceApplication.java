package com.tpi.fleet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Microservicio de gestión de flota (camiones, depósitos, rutas y tramos).
 */
@SpringBootApplication
public class FleetServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FleetServiceApplication.class, args);
    }
}
