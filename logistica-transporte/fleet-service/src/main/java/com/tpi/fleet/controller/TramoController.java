package com.tpi.fleet.controller;

import com.tpi.fleet.entity.Tramo;
import com.tpi.fleet.service.TramoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para gestionar los tramos de una ruta.
 */
@RestController
@RequestMapping("/api/tramos")
public class TramoController {

    private final TramoService service;

    public TramoController(TramoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tramo> listar() {
        return service.listar();
    }

    @PostMapping
    public Tramo crear(@RequestBody Tramo t) {
        return service.crear(t);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}
