package com.tpi.fleet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistanciaDTO {

    private double kilometros;       // dto.setKilometros(...)
    private String duracionTexto;

    public double getKilometros() { return kilometros; }
    public void setKilometros(double kilometros) { this.kilometros = kilometros; }

    public String getDuracionTexto() { return duracionTexto; }
    public void setDuracionTexto(String duracionTexto) { this.duracionTexto = duracionTexto; }

    // duración total en minutos
    private long duracionMin;


    private String origen;
    private String destino;
}
