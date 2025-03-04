# BD_Swing

BD_Swing es un proyecto basado en **Spring WebFlux** que aprovecha la programación reactiva para el manejo eficiente de datos. Este proyecto también está preparado para ejecutarse en **Docker** mediante **Docker Compose**.

## Tecnologías

- **Java 17**
- **Spring Boot**
- **Spring WebFlux**
- **Reactive PostgreSQL**
- **Docker**
- **Docker Compose**

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Configuración y Ejecución

### 1. Clonar el repositorio
```sh
 git clone https://github.com/tuusuario/bd_swing.git
 cd bd_swing
```

### 2. Iniciar los servicios con Docker Compose
```sh
docker-compose up -d
```

### 3. Ejecutar el proyecto
```sh
 mvn spring-boot:run
```

## Contribuciones

Si deseas contribuir, por favor abre un issue o un pull request con mejoras o correcciones.

## Licencia

Este proyecto está bajo la licencia JM.

