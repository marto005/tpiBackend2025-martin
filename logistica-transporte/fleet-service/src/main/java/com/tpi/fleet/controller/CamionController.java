package com.tpi.fleet.controller;

import com.tpi.fleet.entity.Camion;
import com.tpi.fleet.service.CamionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para gestionar camiones.
 */
@RestController
@RequestMapping("/api/camiones")
public class CamionController {

    private final CamionService service;

    public CamionController(CamionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Camion> listar() {
        return service.listar();
    }

    @GetMapping("/disponibles")
    public List<Camion> disponibles() {
        return service.disponibles();
    }

    @PostMapping
    public Camion crear(@RequestBody Camion c) {
        return service.crear(c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}
