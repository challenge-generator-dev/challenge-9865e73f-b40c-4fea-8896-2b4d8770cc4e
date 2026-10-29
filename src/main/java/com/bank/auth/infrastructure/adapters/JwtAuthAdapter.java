package com.bank.auth.infrastructure.adapters;

import com.bank.auth.domain.model.User;
import com.bank.auth.domain.ports.AuthServicePort;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtAuthAdapter implements AuthServicePort {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    @Override
    public String authenticateWithPassword(String username, String password) {
        throw new UnsupportedOperationException("Metodo no implementado - superficie de practica");
    }

    @Override
    public String authenticateWithJwt(String token) {
        throw new UnsupportedOperationException("Metodo no implementado - superficie de practica");
    }

    @Override
    public String generateToken(User user) {
        throw new UnsupportedOperationException("Metodo no implementado - superficie de practica");
    }

    @Override
    public Map<String, Object> validateToken(String token) {
        throw new UnsupportedOperationException("Metodo no implementado - superficie de practica");
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}