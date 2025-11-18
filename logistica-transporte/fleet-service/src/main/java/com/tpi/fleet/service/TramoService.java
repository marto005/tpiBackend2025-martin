package com.tpi.fleet.service;

import com.tpi.fleet.entity.Tramo;
import com.tpi.fleet.repository.TramoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de tramos de ruta.
 */
@Service
public class TramoService {

    private final TramoRepository repo;

    public TramoService(TramoRepository repo) {
        this.repo = repo;
    }

    public List<Tramo> listar() {
        return repo.findAll();
    }

    public Tramo crear(Tramo t) {
        return repo.save(t);
    }

    public Optional<Tramo> buscarPorId(String id) {
        return repo.findById(id);
    }

    public void eliminar(String id) {
        if (!repo.existsById(id))
            throw new IllegalArgumentException("No existe el tramo especificado");
        repo.deleteById(id);
    }
}
