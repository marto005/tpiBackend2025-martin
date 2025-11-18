package com.tpi.fleet.controller;

import com.tpi.fleet.entity.Deposito;
import com.tpi.fleet.service.DepositoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para gestionar depósitos.
 */
@RestController
@RequestMapping("/api/depositos")
public class DepositoController {

    private final DepositoService service;

    public DepositoController(DepositoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Deposito> listar() {
        return service.listar();
    }

    @PostMapping
    public Deposito crear(@RequestBody Deposito d) {
        return service.crear(d);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminar(id);
    }
}
