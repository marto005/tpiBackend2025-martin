package com.tpi.fleet.controller;

import com.tpi.fleet.entity.Ruta;
import com.tpi.fleet.service.RutaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para gestionar rutas completas.
 */
@RestController
@RequestMapping("/api/rutas")
public class RutaController {

    private final RutaService service;

    public RutaController(RutaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ruta> listar() {
        return service.listar();
    }

    @PostMapping
    public Ruta crear(@RequestBody Ruta r) {
        return service.crear(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}
