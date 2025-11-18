package com.tpi.fleet.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Representa un punto intermedio o depósito donde se almacenan contenedores temporalmente.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nombre;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private Double costoEstadiaDiario;
}
