package com.tpi.fleet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {

    @GetMapping("/publico/test")
    public String publicoTest() {
        return "Public OK";
    }

    @GetMapping("/protegido-usuarios/test")
    public String protegidoUsuariosTest() {
        return "Usuarios OK";
    }

    @GetMapping("/protegido-administradores/test")
    public String protegidoAdminTest() {
        return "Admin OK";
    }
}