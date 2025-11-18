package com.tpi.fleet.service;

import com.tpi.fleet.entity.Camion;
import com.tpi.fleet.repository.CamionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de camiones.
 */
@Service
public class CamionService {

    private final CamionRepository repo;

    public CamionService(CamionRepository repo) {
        this.repo = repo;
    }

    public List<Camion> listar() {
        return repo.findAll();
    }

    public List<Camion> disponibles() {
        return repo.findByDisponibleTrue();
    }

    public Camion crear(Camion c) {
        return repo.save(c);
    }

    public Optional<Camion> buscarPorId(String id) {
        return repo.findById(id);
    }

    public void eliminar(String id) {
        if (!repo.existsById(id))
            throw new IllegalArgumentException("No existe el camión especificado");
        repo.deleteById(id);
    }
}
