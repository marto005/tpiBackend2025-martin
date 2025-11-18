package com.tpi.orders.service;

import com.tpi.orders.entity.Contenedor;
import com.tpi.orders.repository.ContenedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de contenedores.
 * Maneja operaciones CRUD y validaciones básicas.
 */
@Service
public class ContenedorService {

    private final ContenedorRepository repo;

    public ContenedorService(ContenedorRepository repo) {
        this.repo = repo;
    }

    /**
     * Retorna todos los contenedores registrados.
     */
    public List<Contenedor> listar() {
        return repo.findAll();
    }

    /**
     * Crea o guarda un nuevo contenedor.
     */
    public Contenedor crear(Contenedor c) {
        return repo.save(c);
    }

    /**
     * Busca un contenedor por su ID.
     */
    public Optional<Contenedor> buscarPorId(String id) {
        return repo.findById(id);
    }

    /**
     * Elimina un contenedor existente.
     */
    public void eliminar(String id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("No existe un contenedor con el ID especificado");
        }
        repo.deleteById(id);
    }
}
