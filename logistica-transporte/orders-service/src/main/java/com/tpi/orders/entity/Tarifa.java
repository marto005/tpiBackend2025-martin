package com.tpi.orders.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa las tarifas base de cálculo (costo por km, litro, etc.)
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String descripcion;
    private Double valorKmBase;
    private Double valorLitroCombustible;
    private Double cargoGestionTramo;
}
