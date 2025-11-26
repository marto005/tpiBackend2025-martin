package com.tpi.fleet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // para APIs REST, deshabilitamos CSRF
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        // ENDPOINTS PÚBLICOS
                        .requestMatchers("/publico/**", "/actuator/**").permitAll()
                        // ENDPOINTS PROTEGIDOS POR ROLES
                        .requestMatchers("/protegido-usuarios/**").hasAnyRole("USUARIO", "ADMIN")
                        .requestMatchers("/protegido-administradores/**").hasRole("ADMIN")
                        // TODO lo demás requiere autenticación
                        .anyRequest().authenticated()
                )
                // usamos JWT como método de autenticación
                .oauth2ResourceServer(oauth -> oauth
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(this::jwtToAuth))
                );

        return http.build();
    }

    private AbstractAuthenticationToken jwtToAuth(Jwt jwt) {
        Map<String, Object> realmAccess = jwt.getClaim("realm_access");
        List<String> roles = List.of();
        if (realmAccess != null && realmAccess.get("roles") instanceof List<?> r) {
            roles = (List<String>) r;
        }
        Collection<? extends GrantedAuthority> authorities = roles.stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r))
                .toList();
        return new JwtAuthenticationToken(jwt, authorities);
    }
}
