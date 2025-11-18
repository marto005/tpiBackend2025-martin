package com.tpi.orders.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController {

    @GetMapping("/publico/ping")
    public Map<String, String> publico() {
        return Map.of("msg","pong publico (fleet)");
    }

    @GetMapping("/protegido-usuarios/ping")
    public Map<String, String> usuarios() {
        return Map.of("msg","pong usuarios/admin (fleet)");
    }

    @GetMapping("/protegido-administradores/ping")
    public Map<String, String> admin() {
        return Map.of("msg","pong admin (fleet)");
    }

    @GetMapping("/me")
    public Map<String, Object> me(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
                "sub", jwt.getSubject(),
                "preferred_username", jwt.getClaimAsString("preferred_username"),
                "realm_access", jwt.getClaim("realm_access")
        );
    }
}
