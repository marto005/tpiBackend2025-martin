package com.tpi.fleet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Representa la ruta completa de una solicitud,
 * compuesta por uno o más tramos.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String solicitudId;
    private Integer cantidadTramos;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tramo> tramos;
}
