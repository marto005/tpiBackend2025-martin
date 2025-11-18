package com.tpi.orders.service;

import com.tpi.orders.entity.Solicitud;
import com.tpi.orders.repository.SolicitudRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SolicitudService {
    private final SolicitudRepository repo;

    public SolicitudService(SolicitudRepository repo) {
        this.repo = repo;
    }

    public List<Solicitud> listar() {
        return repo.findAll();
    }

    public Solicitud crear(Solicitud s) {
        s.setEstado("borrador");
        return repo.save(s);
    }
}
