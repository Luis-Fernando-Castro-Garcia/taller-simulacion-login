# Simulador de Login

Aplicación de escritorio en JavaFX que simula un flujo de inicio de sesión con validación de credenciales, roles de usuario y una pantalla de bienvenida personalizada.

## Descripción

El proyecto presenta una ventana de login **sin bordes nativos** (estilo `TRANSPARENT`), con una barra superior personalizada que permite cerrar y arrastrar la ventana manualmente. Al autenticarse correctamente, se abre una segunda ventana de bienvenida con el nombre del usuario.

## Tecnologías

- Java
- JavaFX (SDK manual, sin FXML — interfaz construida 100% en código)
- CSS personalizado (una hoja de estilos por vista)
- NetBeans

## Arquitectura (MVC + Singleton)

- **`model`**: `Usuario` (datos del usuario) y `Rol` (enum con los roles `ADMIN` / `USER`).
- **`view`**: `LoginView` y `BienvenidaView` — construyen los componentes visuales de cada pantalla. `LoginView` es un Singleton (una sola instancia reutilizada).
- **`controller`**:
  - `AuthSistema`: valida credenciales contra una lista de usuarios predefinidos.
  - `LoginController`: conecta los eventos de `LoginView` (iniciar sesión, cerrar ventana, arrastrar ventana) con la lógica de autenticación.
  - `SceneManager`: Singleton que centraliza el cambio entre escenas/ventanas de toda la aplicación.
  - `ImageController`: centraliza la carga de imágenes utilizadas en las vistas (patrón Factory).
- **`system`**: `ClasePrincipal` — clase de arranque (extiende `Application`).
- **`styles`**: hojas de estilos CSS (`LoginStyles.css`, `BienvenidaStyle.css`).
- **`resources`**: imágenes utilizadas en la interfaz.

## Funcionalidades

- Ventana sin decoración nativa, con botón de cierre y arrastre personalizados (`setOnMousePressed` / `setOnMouseDragged`).
- Validación de campos vacíos y credenciales inválidas, con retroalimentación visual (clases CSS `empty` / `error`) y alertas.
- Autenticación contra una lista de usuarios en memoria, cada uno con un rol asignado (`ADMIN` o `USER`).
- Transición a una ventana de bienvenida modal tras un login exitoso, mostrando el nombre completo del usuario autenticado.
- Manejo de errores centralizado en `SceneManager`.

## Usuarios de prueba

| Usuario | Contraseña | Rol |
|---|---|---|
| Admin | Admin | ADMIN |
| User | User | USER |
| Luis | 123456789 | USER |

## Cómo ejecutar

1. Abrir el proyecto en NetBeans.
2. Verificar que las VM Options del proyecto incluyan el `module-path` hacia el SDK de JavaFX:
   ```
   --module-path "RUTA_AL_SDK_JAVAFX\lib" --add-modules javafx.controls,javafx.fxml
   ```
3. Ejecutar la clase `ClasePrincipal.java` (paquete `com.lc.system`).

## Autor

Luis Castro
