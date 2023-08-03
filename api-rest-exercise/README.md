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

Pasos detallados para instalar el proyecto. Por ejemplo:

1. Clona el repositorio: `git clone [URL_DEL_REPOSITORIO](https://github.com/Elsarmi/crud-user-application)`
2. Navega hasta el directorio del proyecto: `cd NOMBRE_DEL_PROYECTO`
3. Instala las dependencias: `comando_para_instalar_dependencias`
4. Inicia el servidor: `comando_para_iniciar_el_servidor`

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
