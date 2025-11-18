package com.tpi.fleet.service;

import com.tpi.fleet.dto.DistanciaDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class GeoService {

    private final RestTemplate restTemplate;

    @Value("${google.maps.base-url}")
    private String baseUrl;

    @Value("${google.maps.api-key}")
    private String apiKey;

    public DistanciaDTO calcularDistancia(String origen, String destino) {
        if (apiKey == null || apiKey.isBlank()) {
            log.error("GOOGLE_MAPS_API_KEY no configurada!");
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "API Key de Google Maps no configurada"
            );
        }

        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("origins", origen)
                .queryParam("destinations", destino)
                .queryParam("language", "es-419")
                .queryParam("key", apiKey)
                .toUriString();

        log.info("Llamando a Google Maps Distance Matrix: {}", url);

        try {
            Map<?, ?> response = restTemplate.getForObject(url, Map.class);
            log.debug("Respuesta Google: {}", response);


            List<?> rows = (List<?>) response.get("rows");
            if (rows == null || rows.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sin filas en la respuesta de Google");
            }

            Map<?, ?> row0 = (Map<?, ?>) rows.get(0);
            List<?> elements = (List<?>) row0.get("elements");
            if (elements == null || elements.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sin elementos en la respuesta de Google");
            }

            Map<?, ?> element0 = (Map<?, ?>) elements.get(0);
            Map<?, ?> distance = (Map<?, ?>) element0.get("distance");
            Map<?, ?> duration = (Map<?, ?>) element0.get("duration");

            double metros = ((Number) distance.get("value")).doubleValue();
            double kilometros = metros / 1000.0;

            String duracionTexto = (String) duration.get("text");
            long duracionSeg = ((Number) duration.get("value")).longValue();
            long duracionMin = duracionSeg / 60;

            DistanciaDTO dto = new DistanciaDTO();
            dto.setKilometros(kilometros);
            dto.setDuracionTexto(duracionTexto);
            dto.setDuracionMin(duracionMin);
            dto.setOrigen(origen);
            dto.setDestino(destino);

            return dto;

        } catch (HttpStatusCodeException e) {
            log.error("Error HTTP al llamar a Google Maps: status={}, body={}",
                    e.getStatusCode(), e.getResponseBodyAsString());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error llamando a Google Maps");
        } catch (Exception e) {
            log.error("Error inesperado calculando distancia", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error interno calculando distancia");
        }
    }
}

