package com.tpi.orders.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa un contenedor físico que será trasladado.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contenedor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String codigoUnico;

    private Double peso;
    private Double volumen;
    private String estado;
}
