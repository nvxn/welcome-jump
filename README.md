# Welcome Jump Mod (Troll Edition)

**Welcome Jump** es un mod para **Minecraft (Forge 1.20.1)** diseñado para sembrar el caos y la paranoia en tu servidor.

¿Cansado de que las entradas al servidor sean aburridas? Con este mod, cada vez que alguien se conecta, se activa el **"Protocolo de Pánico"**: todos los jugadores conectados sufren una experiencia traumática y divertida.

## 🚀 Características (El "Combo del Pánico")

Cuando un jugador entra al servidor, el mod espera 3 segundos (para que cargue texturas) y ejecuta lo siguiente sobre **todos los demás jugadores**:

1.  **Audio Psicológico:** Suena un `Creeper Prime` (sssSS Sssh...) justo detrás de la oreja.
2.  **Mareo Instantáneo:** Aplica efecto de **Nausea** (Confusión) para desorientar visualmente.
3.  **Efecto "Pochoclo" (Popcorn):** Lanza a los jugadores por los aires en **direcciones aleatorias** (Norte, Sur, Este, Oeste) con una fuerza vertical potente.
4.  **Trimple Impacto:** La trampa se ejecuta tres veces (a los 3s, 5s y 6s) para asegurar que nadie se salve.

## 📋 Requisitos Técnicos

* **Minecraft:** 1.20.1
* **Forge:** 47.1.0 (o superior)
* **Java:** 17

## 🛠️ Instalación

1.  Descarga el archivo `.jar` desde la sección de Releases (o compílalo tú mismo).
2.  Instala **Minecraft Forge 1.20.1** en tu cliente y servidor.
3.  Coloca el archivo `.jar` en la carpeta `mods` tanto del **Servidor** como del **Cliente**.
4.  ¡Inicia el juego y espera a que entre tu primera víctima!

## 🧑‍💻 Compilación (Para Desarrolladores)

Si quieres modificar el código o compilarlo tú mismo:

```bash
# Clonar el repositorio
git clone https://github.com/notkpc/welcome-jump.git

# Entrar en la carpeta
cd welcome-jump

# Compilar (Windows)
.\gradlew build

# Compilar (Linux/Mac)
./gradlew build

```

El archivo final estará en `build/libs/*`.

## ⚠️ Disclaimer

Este mod está diseñado para **servidores privados con amigos**. El autor no se hace responsable de:

* Items perdidos por caídas desde grandes alturas.
* Infartos causados por sonidos de Creeper fantasma.
* Amistades rotas.

Developed by [notkpc](https://www.notkpc.com.ar).
