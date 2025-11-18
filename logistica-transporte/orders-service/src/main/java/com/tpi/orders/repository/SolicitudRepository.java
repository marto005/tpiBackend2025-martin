package com.tpi.orders.repository;

import com.tpi.orders.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, String> { }
