# Foro Hub - Challenge - Back End

Foro Hub es una aplicación de foro diseñada para facilitar la comunicación y discusión entre usuarios. Esta aplicación permite a los usuarios crear tópicos, responder a los mismos y participar en discusiones y para eso hemos creado una API REST usando Spring.


![swagger.png](hub%2FBadge-Spring.png)

## Características

- Registro y autenticación de usuarios.
- Creación, edición y eliminación de tópicos.
- Respuesta a tópicos existentes.
- Listado de usuarios y tópicos.
- Autenticación mediante JWT.

## Tecnologías utilizadas

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- JPA (Java Persistence API)
- H2 Database (para desarrollo y pruebas)
- Insomnia (para pruebas del API REST)
- Swagger (para documentación de API REST)

## Estructura del proyecto

- **Entities**: Clases de entidad que representan las tablas de la base de datos.
- **Dto**: Clases de Data Transfer Object utilizadas para transferir datos entre el cliente y el servidor.
- **Repository**: Interfaces que extienden JpaRepository para realizar operaciones CRUD en las entidades.
- **Service**: Clases de servicio que contienen la lógica de negocio.
- **Controller**: Clases de controlador que manejan las solicitudes HTTP.
- **Security**: Clases relacionadas con la configuración de seguridad y la autenticación.

## Instalación y configuración

- Clone este repositorio.
- Abre el proyecto en un IDE.
- Configure la conexión con el servidor de base de datos MySQL (`usuario` y `password`).
- Cree en el servidor de base de datos MySQL la base de datos: `api`.
```
NOTA: Si requiere realizar cambios en la configuración de la base de datos puede cambiarla en el archivo de propiedades application.ymll.
```

### Swagger
Swagger se ha configurado para generar documentación de la API REST automáticamente. Para acceder a la interfaz de Swagger en la siguiente URL cuando el servidor esté en funcionamiento:
```
http://localhost:8080/swagger-ui/index.html
```
![swagger.png](hub%2Fswagger.png)

Ejecución

```
http://localhost:8080
```

Endpoints principales:
- `/login`: Endpoint para autenticación de usuarios y envía una solicitud POST con un JSON que contiene `username` y `password`.
- `/usuarios`: Endpoint para listar usuarios se requiere autenticación mediante un token JWT.
- `/topicos`: Endpoint para manejar la creación, actualización y eliminación de tópicos.

### Ejemplos de solicitudes

- Autenticación

Solicitud:
```
POST http://localhost:8080/login
```
Body:
```
{
    "username": "nombre_usuario",
    "password": "contraseña"
}
```
Respuesta:
```
{
    "token": "jwt_token_generado"
}
```
- Crear un tópico

Solicitud:
```
GET http://localhost:8080/topico/topicos
```
Headers:
```
Authorization: Bearer jwt_token_generado
Content-Type: application/json
```
Body:
```
{
  "totalPages": 1,
  "totalElements": 1,
  "size": 1,
  "content": [
    {
      "id": 1,
      "title": "Error al ejecutar una requisición",
      "message": "HTTP en la web",
      "status": "ACTIVO",
      "usuario_Id": 1,
      "curso": "Error de validación HTTP",
      "date": "2025-01-21T08:00:00.000Z"
    },
  ],
  "number": 0,
  "sort": "asc",
  "first": true,
  "last": true,
  "numberOfElements": 1,
  "pageable": {
    "offset": 0,
    "sort": "asc",
    "paged": true,
    "unpaged": true,
    "pageNumber": 0,
    "pageSize": 1
  },
  "empty": false
}