package com.tpi.fleet.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa un camión dentro de la flota de transporte.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Camion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String dominio;

    private String nombreTransportista;
    private String telefono;
    private Double capacidadPeso;
    private Double capacidadVolumen;
    private Double consumoLKm;
    private Double costoBaseKm;
    private Boolean disponible = true;
}
