# Implementación de Autenticación Segura en un Sistema de Gestión de Cuentas Bancarias

Como especialista en framework y seguridad, tu tarea es implementar un sistema de autenticación robusto y legible para un sistema de gestión de cuentas bancarias. El sistema debe soportar dos mecanismos de autenticación: uno basado en contraseña y otro basado en JWT. Los actores involucrados son el Cliente, el Sistema de Autenticación y el Sistema de Gestión de Cuentas. El sistema debe manejar casos de autenticación fallida y proporcionar retroalimentación clara al usuario.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Especialista en Framework con Proficiencia en Seguridad y Legibilidad de Código |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del Entorno y Mecanismo de Autenticación Basado en Contraseña

**Objetivo:** Configurar el entorno de desarrollo y establecer un mecanismo de autenticación basado en contraseña.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Configura el entorno de desarrollo para el sistema de gestión de cuentas bancarias.
- Implementa un mecanismo de autenticación basado en contraseña que verifique las credenciales del Cliente contra la base de datos.
- Maneja casos de autenticación fallida y proporciona retroalimentación al Cliente.

**Entregable:** Entorno de desarrollo configurado y mecanismo de autenticación basado en contraseña implementado.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la legibilidad y reutilización del código al implementar el mecanismo de autenticación.
- Piensa en cómo manejar errores de autenticación de manera efectiva.

</details>

### Fase 2: Implementación de Autenticación Basada en JWT

**Objetivo:** Implementar un mecanismo de autenticación basado en JWT y asegurar la comunicación entre el Cliente y el Sistema de Gestión de Cuentas.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementa un mecanismo de autenticación basado en JWT que genere y valide tokens para el Cliente.
- Asegura que la comunicación entre el Cliente y el Sistema de Gestión de Cuentas sea segura utilizando el JWT.
- Maneja casos de tokens inválidos o expirados y proporciona retroalimentación al Cliente.

**Entregable:** Mecanismo de autenticación basado en JWT implementado y comunicación segura establecida.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la seguridad y la legibilidad del código al implementar el mecanismo de autenticación basado en JWT.
- Piensa en cómo manejar tokens inválidos o expirados de manera efectiva.

</details>

### Fase 3: Revisión y Optimización del Código

**Objetivo:** Revisar y optimizar el código implementado para asegurar la legibilidad, reutilización y seguridad.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Revisa el código implementado en las fases anteriores para identificar áreas de mejora en términos de legibilidad y reutilización.
- Optimiza el código para asegurar que sea seguro y eficiente.
- Documenta el código y proporciona ejemplos de uso para facilitar la comprensión y reutilización por parte de otros desarrolladores.

**Entregable:** Código revisado y optimizado, documentado con ejemplos de uso.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las mejores prácticas de codificación y documentación para asegurar la legibilidad y reutilización del código.
- Piensa en cómo puedes mejorar la seguridad y eficiencia del código.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un JWT y cómo se utiliza en la autenticación?
- **paraQueSirve**: ¿Para qué sirve la autenticación basada en contraseña en el sistema de gestión de cuentas bancarias?
- **comoSeUsa**: ¿Cómo se usa un JWT para autenticar a un Cliente en el sistema?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar un mecanismo de autenticación y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones implica la elección entre un mecanismo de autenticación basado en contraseña y uno basado en JWT?

## Criterios de Evaluacion

- Configuración correcta del entorno de desarrollo.
- Implementación de un mecanismo de autenticación basado en contraseña.
- Implementación de un mecanismo de autenticación basado en JWT.
- Manejo efectivo de errores de autenticación.
- Revisión y optimización del código para asegurar legibilidad, reutilización y seguridad.
- Documentación clara y ejemplos de uso del código.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
