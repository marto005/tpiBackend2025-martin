package com.tpi.fleet.service;

import com.tpi.fleet.entity.Deposito;
import com.tpi.fleet.repository.DepositoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de depósitos.
 */
@Service
public class DepositoService {

    private final DepositoRepository repo;

    public DepositoService(DepositoRepository repo) {
        this.repo = repo;
    }

    public List<Deposito> listar() {
        return repo.findAll();
    }

    public Deposito crear(Deposito d) {
        return repo.save(d);
    }

    public Optional<Deposito> buscarPorId(String id) {
        return repo.findById(id);
    }

    public void eliminar(String id) {
        if (!repo.existsById(id))
            throw new IllegalArgumentException("No existe el depósito especificado");
        repo.deleteById(id);
    }
}
