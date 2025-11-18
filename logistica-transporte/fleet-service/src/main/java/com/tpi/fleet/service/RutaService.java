package com.tpi.fleet.service;

import com.tpi.fleet.entity.Ruta;
import com.tpi.fleet.repository.RutaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de rutas de traslado.
 */
@Service
public class RutaService {

    private final RutaRepository repo;

    public RutaService(RutaRepository repo) {
        this.repo = repo;
    }

    public List<Ruta> listar() {
        return repo.findAll();
    }

    public Ruta crear(Ruta r) {
        return repo.save(r);
    }

    public Optional<Ruta> buscarPorId(String id) {
        return repo.findById(id);
    }

    public void eliminar(String id) {
        if (!repo.existsById(id))
            throw new IllegalArgumentException("No existe la ruta especificada");
        repo.deleteById(id);
    }
}

