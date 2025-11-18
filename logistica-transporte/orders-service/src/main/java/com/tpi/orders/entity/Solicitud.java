package com.tpi.orders.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa una solicitud de transporte generada por un cliente.
 * Incluye referencias al contenedor, estado y costos estimados.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contenedor_id", nullable = false)
    private Contenedor contenedor;

    private String estado; // borrador, programada, en_transito, entregada
    private Double costoEstimado;
    private Integer tiempoEstimado;
    private Double costoFinal;
    private Integer tiempoReal;
}
