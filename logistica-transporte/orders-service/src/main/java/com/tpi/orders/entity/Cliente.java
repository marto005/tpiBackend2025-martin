package com.tpi.orders.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa un cliente que solicita el transporte de un contenedor.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    private String telefono;
}
