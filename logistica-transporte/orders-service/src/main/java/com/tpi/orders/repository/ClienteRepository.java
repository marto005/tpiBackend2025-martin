package com.tpi.orders.repository;

import com.tpi.orders.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    boolean existsByEmail(String email);
}
