package com.bank.auth.infrastructure.controllers;

import com.bank.auth.application.services.AuthService;
import com.bank.auth.domain.model.User;
import com.bank.auth.infrastructure.config.SecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@Import(SecurityConfig.class)
@DisplayName("Pruebas de integración para AuthController")
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthService authService;

    private User testUser;
    private String userJson;

    @BeforeEach
    void setUp() throws Exception {
        testUser = new User(
            UUID.randomUUID(),
            "testuser",
            "test@bank.com",
            "hashedPassword",
            LocalDateTime.now(),
            LocalDateTime.now(),
            true
        );

        userJson = """
            {
                "username": "testuser",
                "password": "password123"
            }
            """;
    }

    @Test
    @DisplayName("POST /api/auth/login - Autenticación exitosa")
    void login_WithValidCredentials_ReturnsToken() throws Exception {
        // Given
        String expectedToken = "jwt-token-response";
        when(authService.authenticate(anyString(), anyString())).thenReturn(expectedToken);

        // When & Then
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.token").value(expectedToken))
            .andExpect(jsonPath("$.type").value("Bearer"));

        verify(authService).authenticate("testuser", "password123");
    }

    @Test
    @DisplayName("POST /api/auth/login - Autenticación fallida con credenciales inválidas")
    void login_WithInvalidCredentials_ReturnsUnauthorized() throws Exception {
        // Given
        when(authService.authenticate(anyString(), anyString())).thenReturn(null);

        // When & Then
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
            .andExpect(status().isUnauthorized())
            .andExpect(jsonPath("$.error").exists());

        verify(authService).authenticate("testuser", "password123");
    }

    @Test
    @DisplayName("POST /api/auth/login - Solicitud con datos vacíos")
    void login_WithEmptyBody_ReturnsBadRequest() throws Exception {
        // Given
        String emptyJson = "{}";

        // When & Then
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(emptyJson))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists());
    }

    @Test
    @DisplayName("POST /api/auth/register - Registro exitoso de usuario")
    void register_WithValidData_ReturnsCreated() throws Exception {
        // Given
        String registerJson = """
            {
                "username": "newuser",
                "email": "newuser@bank.com",
                "password": "password123"
            }
            """;

        when(authService.register(any(User.class))).thenReturn(testUser);

        // When & Then
        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(registerJson))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.username").value("newuser"));

        verify(authService).register(any(User.class));
    }

    @Test
    @DisplayName("POST /api/auth/register - Registro con email inválido")
    void register_WithInvalidEmail_ReturnsBadRequest() throws Exception {
        // Given
        String invalidEmailJson = """
            {
                "username": "newuser",
                "email": "invalid-email",
                "password": "password123"
            }
            """;

        // When & Then
        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidEmailJson))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors").exists());
    }

    @Test
    @DisplayName("GET /api/auth/validate - Token válido")
    void validateToken_WithValidToken_ReturnsOk() throws Exception {
        // Given
        String validToken = "valid-jwt-token";

        // When
        // TODO: Implementar validación de token

        // Then
        mockMvc.perform(get("/api/auth/validate")
                .header("Authorization", "Bearer " + validToken))
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /api/auth/validate - Token faltante")
    void validateToken_WithoutToken_ReturnsUnauthorized() throws Exception {
        // When & Then
        mockMvc.perform(get("/api/auth/validate"))
            .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("GET /api/auth/validate - Token inválido")
    void validateToken_WithInvalidToken_ReturnsUnauthorized() throws Exception {
        // Given
        String invalidToken = "invalid-token";

        // When
        // TODO: Implementar validación de token inválido

        // Then
        mockMvc.perform(get("/api/auth/validate")
                .header("Authorization", "Bearer " + invalidToken))
            .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("POST /api/auth/refresh - Renovación de token")
    void refreshToken_WithValidToken_ReturnsNewToken() throws Exception {
        // Given
        String refreshToken = "refresh-jwt-token";
        String newToken = "new-access-token";

        // When
        // TODO: Implementar renovación de token

        // Then
        mockMvc.perform(post("/api/auth/refresh")
                .header("Authorization", "Bearer " + refreshToken))
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST /api/auth/logout - Cierre de sesión")
    void logout_WithValidToken_ReturnsOk() throws Exception {
        // Given
        String token = "valid-jwt-token";

        // When
        // TODO: Implementar cierre de sesión

        // Then
        mockMvc.perform(post("/api/auth/logout")
                .header("Authorization", "Bearer " + token))
            .andExpect(status().isOk());
    }
}