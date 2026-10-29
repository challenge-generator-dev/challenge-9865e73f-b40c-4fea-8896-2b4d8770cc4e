package com.bank.auth.application.services;

import com.bank.auth.domain.model.User;
import com.bank.auth.domain.ports.AuthServicePort;
import com.bank.auth.domain.ports.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para AuthService")
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthServicePort authServicePort;

    @InjectMocks
    private AuthService authService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User(
            UUID.randomUUID(),
            "testuser",
            "test@bank.com",
            "hashedPassword",
            LocalDateTime.now(),
            LocalDateTime.now(),
            true
        );
    }

    @Test
    @DisplayName("Autenticación exitosa con credenciales válidas")
    void authenticateWithValidCredentials_ReturnsToken() {
        // Given
        String username = "testuser";
        String password = "password123";
        String expectedToken = "jwt-token-here";

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(testUser));
        when(authServicePort.authenticateWithPassword(username, password)).thenReturn(expectedToken);

        // When
        String result = authService.authenticate(username, password);

        // Then
        assertNotNull(result);
        assertEquals(expectedToken, result);
        verify(userRepository).findByUsername(username);
        verify(authServicePort).authenticateWithPassword(username, password);
    }

    @Test
    @DisplayName("Autenticación fallida con usuario inexistente")
    void authenticateWithNonExistentUser_ThrowsException() {
        // Given
        String username = "nonexistent";
        String password = "password123";

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(RuntimeException.class, () -> authService.authenticate(username, password));
        verify(userRepository).findByUsername(username);
        verify(authServicePort, never()).authenticateWithPassword(anyString(), anyString());
    }

    @Test
    @DisplayName("Autenticación fallida con contraseña incorrecta")
    void authenticateWithWrongPassword_ThrowsException() {
        // Given
        String username = "testuser";
        String wrongPassword = "wrongpassword";

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(testUser));
        when(authServicePort.authenticateWithPassword(username, wrongPassword)).thenReturn(null);

        // When
        String result = authService.authenticate(username, wrongPassword);

        // Then
        assertNull(result);
        verify(userRepository).findByUsername(username);
        verify(authServicePort).authenticateWithPassword(username, wrongPassword);
    }

    @Test
    @DisplayName("Validación de token JWT exitoso")
    void validateToken_WithValidToken_ReturnsClaims() {
        // Given
        String validToken = "valid.jwt.token";

        // When
        // TODO: Implementar validación de token JWT

        // Then
        fail("Test no implementado");
    }

    @Test
    @DisplayName("Validación de token JWT expirado")
    void validateToken_WithExpiredToken_ThrowsException() {
        // Given
        String expiredToken = "expired.jwt.token";

        // When
        // TODO: Implementar validación de token expirado

        // Then
        fail("Test no implementado");
    }

    @Test
    @DisplayName("Validación de token JWT inválido")
    void validateToken_WithInvalidToken_ThrowsException() {
        // Given
        String invalidToken = "invalid-token";

        // When
        // TODO: Implementar validación de token inválido

        // Then
        fail("Test no implementado");
    }

    @Test
    @DisplayName("Registro de nuevo usuario exitoso")
    void registerUser_WithValidData_ReturnsUser() {
        // Given
        User newUser = new User(
            UUID.randomUUID(),
            "newuser",
            "newuser@bank.com",
            "hashedPassword",
            LocalDateTime.now(),
            LocalDateTime.now(),
            true
        );

        when(userRepository.findByUsername(newUser.getUsername())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(newUser.getEmail())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(newUser);

        // When
        // TODO: Implementar registro de usuario

        // Then
        fail("Test no implementado");
    }

    @Test
    @DisplayName("Registro de usuario con username duplicado")
    void registerUser_WithDuplicateUsername_ThrowsException() {
        // Given
        when(userRepository.findByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));

        // When
        // TODO: Implementar validación de username duplicado

        // Then
        fail("Test no implementado");
    }
}