package com.tpi.fleet.controller;

import com.tpi.fleet.dto.DistanciaDTO;
import com.tpi.fleet.service.GeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/geo")
@RequiredArgsConstructor
public class GeoController {

    private final GeoService geoService;

    @PostMapping("/distancia")
    @ResponseStatus(HttpStatus.OK)
    public DistanciaDTO calcular(@RequestBody GeoRequest request) {
        // GeoRequest es un DTO simple con origen y destino
        return geoService.calcularDistancia(request.getOrigen(), request.getDestino());
    }
}

