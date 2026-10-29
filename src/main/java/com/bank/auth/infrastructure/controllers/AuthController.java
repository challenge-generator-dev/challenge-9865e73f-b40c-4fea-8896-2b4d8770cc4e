package com.bank.auth.infrastructure.controllers;

import com.bank.auth.domain.ports.AuthServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthServicePort authServicePort;

    public AuthController(AuthServicePort authServicePort) {
        this.authServicePort = authServicePort;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        throw new UnsupportedOperationException("Endpoint no implementado - superficie de practica");
    }

    @PostMapping("/jwt")
    public ResponseEntity<?> authenticateWithJwt(@RequestBody Map<String, String> request) {
        throw new UnsupportedOperationException("Endpoint no implementado - superficie de practica");
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        throw new UnsupportedOperationException("Endpoint no implementado - superficie de practica");
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody Map<String, String> request) {
        throw new UnsupportedOperationException("Endpoint no implementado - superficie de practica");
    }
}