package com.tpi.orders.service;

import com.tpi.orders.entity.Tarifa;
import com.tpi.orders.repository.TarifaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que maneja las tarifas base utilizadas para calcular costos.
 */
@Service
public class TarifaService {

    private final TarifaRepository repo;

    public TarifaService(TarifaRepository repo) {
        this.repo = repo;
    }

    /**
     * Devuelve todas las tarifas registradas.
     */
    public List<Tarifa> listar() {
        return repo.findAll();
    }

    /**
     * Registra una nueva tarifa.
     */
    public Tarifa crear(Tarifa t) {
        return repo.save(t);
    }

    /**
     * Busca una tarifa por ID.
     */
    public Optional<Tarifa> buscarPorId(String id) {
        return repo.findById(id);
    }

    /**
     * Elimina una tarifa existente.
     */
    public void eliminar(String id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("No existe una tarifa con ese ID");
        }
        repo.deleteById(id);
    }
}
