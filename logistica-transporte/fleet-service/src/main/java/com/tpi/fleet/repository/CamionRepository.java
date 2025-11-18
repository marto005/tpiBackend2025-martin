package com.tpi.fleet.repository;

import com.tpi.fleet.entity.Camion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CamionRepository extends JpaRepository<Camion, String> {
    List<Camion> findByDisponibleTrue();
}
