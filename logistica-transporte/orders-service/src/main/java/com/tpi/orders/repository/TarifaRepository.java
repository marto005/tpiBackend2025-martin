package com.tpi.orders.repository;

import com.tpi.orders.entity.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarifaRepository extends JpaRepository<Tarifa, String> { }
