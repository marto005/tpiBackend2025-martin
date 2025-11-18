package com.tpi.orders.service;

import com.tpi.orders.entity.Cliente;
import com.tpi.orders.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente crear(Cliente c) {
        if (repo.existsByEmail(c.getEmail())) {
            throw new IllegalArgumentException("Ya existe un cliente con ese email");
        }
        return repo.save(c);
    }
}
