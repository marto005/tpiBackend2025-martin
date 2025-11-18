package com.tpi.orders.controller;

import com.tpi.orders.entity.Tarifa;
import com.tpi.orders.service.TarifaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para la gestión de tarifas.
 * Permite definir los valores base de cálculo para costos.
 */
@RestController
@RequestMapping("/api/tarifas")
public class TarifaController {

    private final TarifaService service;

    public TarifaController(TarifaService service) {
        this.service = service;
    }

    /**
     * Devuelve todas las tarifas configuradas.
     */
    @GetMapping
    public List<Tarifa> listar() {
        return service.listar();
    }

    /**
     * Registra una nueva tarifa.
     */
    @PostMapping
    public Tarifa crear(@RequestBody Tarifa t) {
        return service.crear(t);
    }

    /**
     * Busca una tarifa por su ID.
     */
    @GetMapping("/{id}")
    public Tarifa obtener(@PathVariable String id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarifa no encontrada"));
    }

    /**
     * Elimina una tarifa existente.
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}
