package com.tpi.orders.controller;

import com.tpi.orders.entity.Solicitud;
import com.tpi.orders.service.SolicitudService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador para registrar y consultar solicitudes de transporte.
 */
@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private final SolicitudService service;

    public SolicitudController(SolicitudService service) {
        this.service = service;
    }

    @GetMapping
    public List<Solicitud> listar() {
        return service.listar();
    }

    @PostMapping
    public Solicitud crear(@RequestBody Solicitud s) {
        return service.crear(s);
    }
}
