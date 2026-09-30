# Reto 1 · Tarjeta de Presentación Profesional

**Módulo:** 0489 · Programación Multimedia y Dispositivos Móviles  
**Autor:** Mateo Fernández Blasco  
**Tecnología:** Kotlin + Jetpack Compose (Android nativo)  
**RA vinculado:** RA1 · Tecnologías de desarrollo para dispositivos móviles  

## 📱 Qué es esta app

Una tarjeta de presentación digital interactiva que muestra una foto de perfil, nombre, rol profesional ("Desarrollador de DAM"), botones que enlazan directamente a los perfiles de GitHub y LinkedIn del autor, y un código QR para la visualización/descarga de su CV.


## 🎯 Objetivo del reto

Partir de un proyecto Android base y modificarlo para construir una aplicación funcional propia, aplicando los conceptos vistos en clase: estructura de un proyecto Kotlin, componentes visuales de Jetpack Compose, gestión de recursos (imágenes, archivos y recursos gráficos) e integración de intenciones explícitas/implícitas para abrir enlaces externos.

## 💻 Tecnologías Utilizadas

- **Lenguaje de programación:** [Kotlin](https://kotlinlang.org/) (Lenguaje oficial para desarrollo nativo en Android)
- **Framework de UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (UI declarativa para Android)
- **Sistema de diseño:** [Material Design 3](https://m3.material.io/) (`androidx.compose.material3`)
- **Entorno de Desarrollo (IDE):** [Android Studio](https://developer.android.com/studio)
- **Sistema de construcción:** [Gradle](https://gradle.org/) (Kotlin DSL - `build.gradle.kts`)
- **Componentes de Android SDK:**
  - `ComponentActivity`
  - `Android Intents` (`Intent.ACTION_VIEW` con `Uri`) para apertura de enlaces web externos
  - `LocalContext` para gestión del contexto de la app dentro del árbol de Composables
  - Gestión de recursos Android (`res/drawable`, `res/raw`, `res/mipmap`, `res/values/strings.xml`)
- **Control de versiones:** [Git](https://git-scm.com/) & [GitHub](https://github.com/)

## 🛠️ Componentes y conceptos utilizados

| Componente / concepto | Para qué se usa en esta app |
|---|---|
| `Column` | Organiza los elementos en vertical (foto, nombre, rol, botones, QR) centrándolos en pantalla |
| `Image` + `clip(CircleShape)` | Muestra la foto de perfil (`fotomia.png`) recortada en círculo con ajuste de escala (`ContentScale.Crop`) |
| `Text` | Nombre ("Mateo Fernández Blasco"), rol ("Desarrollador de DAM") y títulos |
| `Spacer` | Define espaciados verticales entre los distintos elementos visuales |
| `Button` + `Intent` | Botones interactivos que, al pulsarse, abren el navegador con los perfiles de GitHub y LinkedIn mediante `Intent(Intent.ACTION_VIEW)` |
| `Image` (QR) | Muestra la imagen del código QR (`qr_code.png`) para consultar/descargar el CV |
| `res/drawable` | Carpeta donde se almacenan las imágenes de la app (`fotomia.png` y `qr_code.png`) |
| `res/raw` | Contiene el archivo del currículum en formato PDF (`cvingles.pdf`) |
| `res/mipmap` (Image Asset Studio) | Icono personalizado de la app (`ic_launcher`), sustituyendo al robot de Android por defecto |
| `strings.xml` (`app_name`) | Nombre visible de la app bajo el icono en el dispositivo (`reto1_primera_app`) |

## 🚀 Cómo ejecutar el proyecto

1. Clonar o abrir el proyecto en Android Studio.
2. Esperar a que sincronice Gradle.
3. Ejecutar (▶) sobre un emulador o un dispositivo Android real con la depuración USB activada.

## 🧠 Qué he aprendido

- Cómo se estructura un proyecto Android/Kotlin con Jetpack Compose.
- Cómo importar y organizar recursos en `res/drawable` y `res/raw`.
- Cómo usar `Column`, `Image`, `Text`, `Spacer` y `Button` para maquetar una interfaz limpia y adaptada.
- Cómo obtener el contexto del sistema con `LocalContext.current` dentro de un Composable para lanzar un `Intent` y abrir URLs externas en el navegador.
- Cómo cambiar e integrar un icono personalizado con Image Asset Studio en `res/mipmap`.
- Cómo personalizar el nombre visible de la app en `strings.xml`.


## 📂 Estructura del proyecto

```
app/src/main/java/.../MainActivity.kt   → pantalla principal (Compose con TarjetaPresentacion)
app/src/main/res/drawable/              → imagen de perfil (fotomia.png) y código QR (qr_code.png)
app/src/main/res/raw/                   → archivo de CV en PDF (cvingles.pdf)
app/src/main/res/mipmap-*/              → icono de la app
app/src/main/res/values/strings.xml     → nombre visible de la app
```

## 🔗 Enlace

- GitHub: [github.com/MateoFB07](https://github.com/MateoFB07)
