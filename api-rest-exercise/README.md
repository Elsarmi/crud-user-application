# API REST Exercise

API REST Exercise es un proyecto desarrollado en Java con Spring Boot, orientado a gestionar usuarios en una plataforma 
web. Utiliza tecnologías como JPA para la persistencia de datos, H2 como base de datos en memoria, JWT para la 
autenticación y Lombok para reducir el boilerplate del código.

## Características

- Crear, leer, actualizar y eliminar (CRUD) usuarios.
- Autenticación a través de tokens JWT.
- Validación de datos de entrada con la librería de validación de Spring Boot.
- Pruebas unitarias con JUnit y Mockito.
- Almacenamiento de datos con H2 database.

## Instalación

Para ejecutar este proyecto localmente, sigue estos pasos:

1. Clona el repositorio en tu máquina local `git clone https://github.com/Elsarmi/crud-user-application/tree/main/api-rest-exercise`
2. Asegúrate de tener instalado JDK 11 o una versión superior.
3. Asegúrate de tener Gradle instalado, puedes obtenerlo [aquí](https://gradle.org/install/).
4. Instala las dependencias: `gradle build`
5. Inicia el servidor: `gradle bootRun`

Una vez que la aplicación esté en marcha, puedes interactuar con la API a través de la siguiente ruta base: `http://localhost:8080/`.

## Uso

Una vez que la aplicación esté en marcha, puedes interactuar con la API a través de la siguiente 
ruta base: `http://localhost:8080/`.

Rutas de la API:

- POST `/users`: Crea un nuevo usuario.
- GET `/users/{id}`: Obtiene el usuario con el ID especificado.
- PUT `/users/{id}`: Actualiza el usuario con el ID especificado.
- DELETE `/users/{id}`: Elimina el usuario con el ID especificado.

## Pruebas

Para ejecutar las pruebas unitarias, utiliza el comando `gradle test`.


## Contacto

Sebastian Sarmiento G - sebastian.sarmiento94@gmail.com
