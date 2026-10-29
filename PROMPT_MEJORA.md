# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/bank/auth/domain/model/User.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/domain/ports/UserRepository.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/domain/ports/AuthServicePort.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/application/services/AuthService.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/adapters/JpaUserRepository.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/adapters/JwtAuthAdapter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/config/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/controllers/AuthController.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/repositories/UserJpaRepository.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/config/OpenApiConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/exceptions/GlobalExceptionHandler.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/exceptions/CustomAuthenticationException.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/bank/auth/infrastructure/exceptions/InvalidTokenException.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/bank/auth/application/services/AuthServiceTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/bank/auth/infrastructure/controllers/AuthControllerTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/bank/auth/infrastructure/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.Components pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/bank/auth/infrastructure/adapters/JpaUserRepository.java` — `UserJpaRepository.save`: Se invoca `save` sobre `UserJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/auth/infrastructure/adapters/JpaUserRepository.java` — `UserJpaRepository.findById`: Se invoca `findById` sobre `UserJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bank/auth/infrastructure/adapters/JpaUserRepository.java` — `UserJpaRepository.deleteById`: Se invoca `deleteById` sobre `UserJpaRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/auth/application/services/AuthServiceTest.java` — `AuthService.authenticate`: Se invoca `authenticate` sobre `AuthService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/auth/infrastructure/controllers/AuthControllerTest.java` — `AuthService.authenticate`: Se invoca `authenticate` sobre `AuthService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bank/auth/infrastructure/controllers/AuthControllerTest.java` — `AuthService.register`: Se invoca `register` sobre `AuthService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2

### Brecha de conocimiento
Experto en el marco de trabajo (framework) mas relevante en su lenguaje de programación principal, lo que le permite escribir código más legible y reducir la redundancia. Ha implementado al menos dos mecanismos de autenticación e identifica el uso de un JWT, Experto en el marco de trabajo (framework) mas relevante en su lenguaje de programación principal, lo que le permite escribir código más legible y reducir la redundancia. Ha implementado al menos dos mecanismos de autenticación e identifica el uso de un JWT

### Reto
- Tema: Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de Autenticación Segura en un Sistema de Gestión de Cuentas Bancarias
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración del Entorno y Mecanismo de Autenticación Basado en Contraseña — objetivo: Configurar el entorno de desarrollo y establecer un mecanismo de autenticación basado en contraseña. — entregable (NO resolver): Entorno de desarrollo configurado y mecanismo de autenticación basado en contraseña implementado.
- Fase 2: Implementación de Autenticación Basada en JWT — objetivo: Implementar un mecanismo de autenticación basado en JWT y asegurar la comunicación entre el Cliente y el Sistema de Gestión de Cuentas. — entregable (NO resolver): Mecanismo de autenticación basado en JWT implementado y comunicación segura establecida.
- Fase 3: Revisión y Optimización del Código — objetivo: Revisar y optimizar el código implementado para asegurar la legibilidad, reutilización y seguridad. — entregable (NO resolver): Código revisado y optimizado, documentado con ejemplos de uso.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.bank</groupId>
    <artifactId>auth</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>auth</name>
    <description>Sistema de autenticación para gestión de cuentas bancarias</description>

    <properties>
        <java.version>21</java.version>
        <jjwt.version>0.12.5</jjwt.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>${jjwt.version}</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>${jjwt.version}</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>${jjwt.version}</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.9.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/bank/auth/Application.java ===
package com.bank.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .maxAge(3600);
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bank_auth
    username: bank_user
    password: secure_password
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
  security:
    user:
      name: admin
      password: admin
      roles: ADMIN

application:
  security:
    jwt:
      secret-key: 404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970
      expiration: 86400000 # 24 horas
      refresh-token:
        expiration: 604800000 # 7 días

logging:
  level:
    org.springframework.security: DEBUG
    com.bank.auth: DEBUG

// === ARCHIVO: src/main/java/com/bank/auth/domain/model/User.java ===
package com.bank.auth.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private UUID id;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre de usuario debe tener entre 3 y 50 caracteres")
    private String username;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico debe ser válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;

    public User() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    public User(UUID id, String username, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt, boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    // Getters y setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        this.updatedAt = LocalDateTime.now();
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/domain/ports/UserRepository.java ===
package com.bank.auth.domain.ports;

import com.bank.auth.domain.model.User;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    void deleteById(UUID id);
}

// === ARCHIVO: src/main/java/com/bank/auth/domain/ports/AuthServicePort.java ===
package com.bank.auth.domain.ports;

import com.bank.auth.domain.model.User;
import java.util.Map;

public interface AuthServicePort {
    String authenticateWithPassword(String username, String password);
    String authenticateWithJwt(String token);
    String generateToken(User user);
    Map<String, Object> validateToken(String token);
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/repositories/UserJpaRepository.java ===
package com.bank.auth.infrastructure.repositories;

import com.bank.auth.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/adapters/JpaUserRepository.java ===
package com.bank.auth.infrastructure.adapters;

import com.bank.auth.domain.model.User;
import com.bank.auth.domain.ports.UserRepository;
import com.bank.auth.infrastructure.repositories.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaUserRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public JpaUserRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }

    @Override
    public void deleteById(UUID id) {
        userJpaRepository.deleteById(id);
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/application/services/AuthService.java ===
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

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/adapters/JwtAuthAdapter.java ===
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

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/config/SecurityConfig.java ===
package com.bank.auth.infrastructure.config;

import com.bank.auth.infrastructure.adapters.JwtAuthAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthAdapter jwtAuthAdapter;

    public SecurityConfig(JwtAuthAdapter jwtAuthAdapter) {
        this.jwtAuthAdapter = jwtAuthAdapter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(
                (request, response, chain) -> {
                    throw new UnsupportedOperationException("Filtro no implementado - superficie de practica");
                },
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/controllers/AuthController.java ===
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

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/config/OpenApiConfig.java ===
package com.bank.auth.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de OpenAPI/Swagger para documentar los endpoints de la API.
 * Superficie de práctica: completar la configuración de seguridad y metadatos.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Autenticación Bancaria")
                        .version("1.0")
                        .description("Sistema de autenticación para gestión de cuentas bancarias")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("dev@bank.com")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Token JWT para autenticación")));
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/exceptions/GlobalExceptionHandler.java ===
package com.bank.auth.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones para proporcionar respuestas consistentes
 * en caso de errores. Superficie de práctica: implementar manejo de errores específicos.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Failed");
        response.put("errors", errors);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(CustomAuthenticationException.class)
    public ResponseEntity<Map<String, Object>> handleAuthenticationException(CustomAuthenticationException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.UNAUTHORIZED.value());
        response.put("error", "Authentication Failed");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidTokenException(InvalidTokenException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.FORBIDDEN.value());
        response.put("error", "Invalid Token");
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("error", "Internal Server Error");
        response.put("message", "An unexpected error occurred");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/exceptions/CustomAuthenticationException.java ===
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

// === ARCHIVO: src/main/java/com/bank/auth/infrastructure/exceptions/InvalidTokenException.java ===
package com.bank.auth.infrastructure.exceptions;

public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}

// === ARCHIVO: src/test/java/com/bank/auth/application/services/AuthServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/bank/auth/infrastructure/controllers/AuthControllerTest.java ===
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

// === ARCHIVO: README.md ===
# Sistema de Autenticación Bancaria

## Descripción del Proyecto

Este proyecto implementa un sistema de autenticación robusto para un sistema de gestión de cuentas bancarias. El sistema soporta dos mecanismos de autenticación: autenticación basada en contraseña y autenticación basada en JWT (JSON Web Tokens).

La arquitectura sigue el patrón hexagonal (ports and adapters) con separación estricta de capas:
- **Capa de Dominio**: Entidades y puertos (interfaces) que definen el comportamiento del negocio.
- **Capa de Aplicación**: Servicios que orquestan los casos de uso.
- **Capa de Infraestructura**: Adaptadores que implementan los puertos y configuran el framework.

## Tecnologías Utilizadas

- **Java 21** — Lenguaje de programación
- **Spring Boot 3.5.6** — Framework principal
- **Spring Security** — Seguridad y autenticación
- **Spring Data JPA** — Persistencia de datos
- **jjwt 0.12.5** — Manipulación de JSON Web Tokens
- **PostgreSQL** — Base de datos relacional
- **SpringDoc OpenAPI 2.9.1** — Documentación de API REST

## Estructura del Proyecto

```
auth/
├── src/
│   ├── main/
│   │   ├── java/com/bank/auth/
│   │   │   ├── Application.java                    # Punto de entrada
│   │   │   ├── domain/
│   │   │   │   ├── model/
│   │   │   │   │   └── User.java                   # Entidad de usuario
│   │   │   │   └── ports/
│   │   │   │       ├── AuthServicePort.java        # Puerto de autenticación
│   │   │   │       └── UserRepository.java         # Puerto de repositorio
│   │   │   ├── application/
│   │   │   │   └── services/
│   │   │   │       └── AuthService.java            # Servicio de aplicación
│   │   │   └── infrastructure/
│   │   │       ├── adapters/
│   │   │       │   ├── JpaUserRepository.java      # Adaptador JPA
│   │   │       │   └── JwtAuthAdapter.java         # Adaptador JWT
│   │   │       ├── config/
│   │   │       │   ├── SecurityConfig.java         # Configuración de seguridad
│   │   │       │   └── OpenApiConfig.java          # Configuración de Swagger
│   │   │       ├── controllers/
│   │   │       │   └── AuthController.java         # Controlador REST
│   │   │       └── exceptions/
│   │   │           ├── GlobalExceptionHandler.java # Manejador de errores
│   │   │           ├── CustomAuthenticationException.java
│   │   │           └── InvalidTokenException.java
│   │   └── resources/
│   │       └── application.yml                     # Configuración
│   └── test/
│       └── java/com/bank/auth/
│           ├── application/services/
│           │   └── AuthServiceTest.java
│           └── infrastructure/controllers/
│               └── AuthControllerTest.java
└── pom.xml
```

## Configuración del Entorno

### Prerrequisitos

- JDK 21 instalado
- Maven 3.9+ instalado
- PostgreSQL 15+ instalado y ejecutándose

### Configuración de Base de Datos

El proyecto utiliza PostgreSQL. Asegúrate de tener una base de datos creada:

```sql
CREATE DATABASE auth_db;
CREATE USER auth_user WITH PASSWORD 'your_secure_password';
GRANT ALL PRIVILEGES ON DATABASE auth_db TO auth_user;
```

### Configuración de la Aplicación

El archivo `src/main/resources/application.yml` contiene la configuración principal:

```yaml
spring:
  application:
    name: auth
  datasource:
    url: jdbc:postgresql://localhost:5432/auth_db
    username: auth_user
    password: your_secure_password
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect

app:
  host: localhost
  port: 8080
  jwt:
    secret: your-256-bit-secret-key-for-jwt-signing-must-be-long-enough
    expiration: 86400000

server:
  port: ${app.port}

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
```

**Nota**: La clave JWT (`app.jwt.secret`) debe tener al menos 256 bits de longitud. En producción, utiliza variables de entorno para valores sensibles.

## Ejecución del Proyecto

### Compilación

```bash
mvn clean compile
```

### Ejecución

```bash
mvn spring-boot:run
```

La aplicación arrancará en `http://localhost:8080`

### Documentación API

Una vez iniciada la aplicación, accede a:
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/api-docs`

## Endpoints Disponibles

### Autenticación

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/auth/register` | Registrar nuevo usuario |
| POST | `/api/auth/login` | Autenticar con contraseña |
| POST | `/api/auth/validate` | Validar token JWT |
| GET | `/api/auth/profile` | Obtener perfil del usuario autenticado |

### Ejemplos de Uso

#### Registrar Usuario

```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "juan.perez",
    "email": "juan.perez@banco.com",
    "password": "SecurePass123!"
  }'
```

Respuesta exitosa (201 Created):
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "username": "juan.perez",
  "email": "juan.perez@banco.com",
  "active": true,
  "createdAt": "2025-01-15T10:30:00"
}
```

#### Iniciar Sesión

```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "juan.perez",
    "password": "SecurePass123!"
  }'
```

Respuesta exitosa (200 OK):
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "type": "Bearer",
  "username": "juan.perez",
  "expiresIn": 86400000
}
```

#### Validar Token

```bash
curl -X POST http://localhost:8080/api/auth/validate \
  -H "Content-Type: application/json" \
  -d '{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
  }'
```

Respuesta exitosa (200 OK):
```json
{
  "valid": true,
  "username": "juan.perez",
  "roles": ["ROLE_USER"]
}
```

#### Obtener Perfil (Requiere Autenticación)

```bash
curl -X GET http://localhost:8080/api/auth/profile \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

Respuesta exitosa (200 OK):
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "username": "juan.perez",
  "email": "juan.perez@banco.com",
  "active": true
}
```

## Manejo de Errores

El sistema utiliza códigos HTTP estándar y devuelve mensajes descriptivos:

| Código | Descripción |
|--------|-------------|
| 200 | Operación exitosa |
| 201 | Recurso creado exitosamente |
| 400 | Solicitud inválida |
| 401 | Autenticación fallida |
| 403 | Acceso denegado |
| 404 | Recurso no encontrado |
| 500 | Error interno del servidor |

Ejemplo de respuesta de error (401 Unauthorized):
```json
{
  "timestamp": "2025-01-15T10:30:00",
  "status": 401,
  "error": "Unauthorized",
  "message": "Credenciales inválidas",
  "path": "/api/auth/login"
}
```

## Ejecución de Pruebas

```bash
mvn test
```

Para ver el reporte de cobertura:
```bash
mvn test jacoco:report
```

El reporte se genera en `target/site/jacoco/index.html`

## Consideraciones de Seguridad

1. **Contraseñas**: Se utilizan BCrypt para el hasheo de contraseñas.
2. **JWT**: Los tokens tienen expiración configurable (por defecto 24 horas).
3. **CORS**: Configurado para permitir orígenes específicos.
4. **Validación**: Todos los DTOs validan entrada con anotaciones de Jakarta Validation.
5. **SQL Injection**: Previene mediante el uso de Spring Data JPA con parámetros vinculados.

## Variables de Entorno en Producción

Para producción, configura las siguientes variables de entorno:

```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://production-host:5432/auth_db
export SPRING_DATASOURCE_USERNAME=prod_user
export SPRING_DATASOURCE_PASSWORD=prod_secure_password
export APP_JWT_SECRET=production-secret-key-min-256-bits
```

## Licencia

Proprietario — Banco XYZ
```
