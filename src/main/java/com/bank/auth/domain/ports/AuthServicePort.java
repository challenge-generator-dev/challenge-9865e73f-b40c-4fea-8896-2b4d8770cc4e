package com.bank.auth.domain.ports;

import com.bank.auth.domain.model.User;
import java.util.Map;

public interface AuthServicePort {
    String authenticateWithPassword(String username, String password);
    String authenticateWithJwt(String token);
    String generateToken(User user);
    Map<String, Object> validateToken(String token);
}