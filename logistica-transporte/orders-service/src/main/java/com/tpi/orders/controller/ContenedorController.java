package com.tpi.orders.controller;

import com.tpi.orders.entity.Contenedor;
import com.tpi.orders.service.ContenedorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para gestionar contenedores.
 * Permite registrar, consultar y eliminar contenedores.
 */
@RestController
@RequestMapping("/api/contenedores")
public class ContenedorController {

    private final ContenedorService service;

    public ContenedorController(ContenedorService service) {
        this.service = service;
    }

    /**
     * Devuelve todos los contenedores registrados.
     */
    @GetMapping
    public List<Contenedor> listar() {
        return service.listar();
    }

    /**
     * Crea un nuevo contenedor.
     */
    @PostMapping
    public Contenedor crear(@RequestBody Contenedor c) {
        return service.crear(c);
    }

    /**
     * Busca un contenedor por su ID.
     */
    @GetMapping("/{id}")
    public Contenedor obtener(@PathVariable String id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Contenedor no encontrado"));
    }

    /**
     * Elimina un contenedor.
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}
