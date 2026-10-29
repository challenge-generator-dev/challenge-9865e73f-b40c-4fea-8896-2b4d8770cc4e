package com.bank.auth.application.services;

import com.bank.auth.domain.model.User;
import com.bank.auth.domain.ports.AuthServicePort;
import com.bank.auth.domain.ports.UserRepository;
import com.bank.auth.infrastructure.exceptions.CustomAuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService implements AuthServicePort {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String authenticateWithPassword(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            throw new CustomAuthenticationException("Usuario no encontrado");
        }
        User user = userOpt.get();
        if (!user.isActive()) {
            throw new CustomAuthenticationException("Usuario inactivo");
        }
        return generateToken(user);
    }

    @Override
    public String authenticateWithJwt(String token) {
        Map<String, Object> payload = validateToken(token);
        String username = (String) payload.get("sub");
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isEmpty()) {
            throw new CustomAuthenticationException("Usuario no encontrado");
        }
        return generateToken(userOpt.get());
    }

    @Override
    public String generateToken(User user) {
        return "token-placeholder-" + user.getUsername();
    }

    @Override
    public Map<String, Object> validateToken(String token) {
        if (token == null || token.isEmpty()) {
            throw new CustomAuthenticationException("Token inválido");
        }
        return Map.of("sub", "placeholder", "exp", System.currentTimeMillis() + 3600000);
    }
}