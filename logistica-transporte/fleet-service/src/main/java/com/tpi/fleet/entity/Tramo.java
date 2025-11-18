package com.tpi.fleet.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa un tramo dentro de una ruta (origen → destino).
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tramo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;

    private Double origenLat;
    private Double origenLng;
    private Double destinoLat;
    private Double destinoLng;
    private String tipo; // origen-deposito, deposito-destino, etc.
    private String estado; // estimado, asignado, iniciado, finalizado
    private Double costoAproximado;
    private Double costoReal;
    private String fechaHoraIniEst;
    private String fechaHoraFinEst;
    private String fechaHoraIniReal;
    private String fechaHoraFinReal;

    @ManyToOne
    @JoinColumn(name = "camion_id")
    private Camion camion;
}
