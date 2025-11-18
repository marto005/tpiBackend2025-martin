package com.tpi.orders.controller;

import com.tpi.orders.entity.Cliente;
import com.tpi.orders.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador para operaciones CRUD de clientes.
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente c) {
        return service.crear(c);
    }
}
