package com.bank.auth.infrastructure.exceptions;

/**
 * Excepción personalizada para manejar errores de autenticación.
 * Superficie de práctica: extender según necesidades específicas del dominio.
 */
public class CustomAuthenticationException extends RuntimeException {

    private final String username;

    public CustomAuthenticationException(String message) {
        super(message);
        this.username = null;
    }

    public CustomAuthenticationException(String message, String username) {
        super(message);
        this.username = username;
    }

    public CustomAuthenticationException(String message, Throwable cause) {
        super(message, cause);
        this.username = null;
    }

    public String getUsername() {
        return username;
    }
}