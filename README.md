# Microservices Architecture with Spring Boot, Spring Security, and PostgreSQL

Este proyecto implementa una arquitectura de microservicios utilizando Spring Boot para la lógica de negocio, Spring Security para la autenticación y autorización mediante JWT, y PostgreSQL como sistema de gestión de bases de datos.

## Configuración de Base de Datos

Cada servicio que requiere persistencia de datos debe configurarse para conectarse a PostgreSQL. Asegúrate de tener una instancia de PostgreSQL ejecutándose y una base de datos creada para tu proyecto.

### Ejemplo de Configuración application.yml
yaml
server:
port: 808X # Cambia X por el número de puerto específico para cada servicio

app:
jwtSecret: TuClaveSecretaJWT
jwtExpirationMs: 3600000 # Tiempo de expiración del token JWT en milisegundos

springdoc:
api-docs:
path: /v3/api-docs
swagger-ui:
path: /swagger-ui.html

spring:
datasource:
url: jdbc:postgresql://localhost:5432/nombre_de_tu_base_de_datos
driverClassName: org.postgresql.Driver
username: tu_usuario
password: tu_contraseña
jpa:
database-platform: org.hibernate.dialect.PostgreSQLDialect
hibernate:
ddl-auto: update
show-sql: true
cloud:
compatibility-verifier:
enabled: false
## Servicios y Puertos

security-service: Autenticación y generación de tokens JWT. **Puerto: 8084**
order-service: Gestión de órdenes. **Puerto: 8090**
customer-service: Administración de clientes. **Puerto: 8088**
product-service: Manejo de productos mediante API externa. **Puerto: 8086**
payment-service: Simulación de procesamiento de pagos. **Puerto: 8092**

## Swagger UI para Documentación de la API

Accede a la documentación de la API y prueba los endpoints directamente desde Swagger UI, disponible en:
http://localhost:[puerto]/swagger-ui.html
Reemplaza [puerto] con el número de puerto correspondiente al servicio que deseas consultar.

## Esquema de Base de Datos

### Script de Creación de Tablas

Asegúrate de ejecutar los scripts de creación de tablas necesarias para cada servicio en PostgreSQL. Aquí un ejemplo genérico para una tabla users:
sql
CREATE TABLE users (
id SERIAL PRIMARY KEY,
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
email VARCHAR(50) UNIQUE NOT NULL,
enabled BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE roles (
id SERIAL PRIMARY KEY,
name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE user_roles (
user_id INT NOT NULL,
role_id INT NOT NULL,
PRIMARY KEY (user_id, role_id),
FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE
);

CREATE TABLE customers (
id SERIAL PRIMARY KEY,
user_id INTEGER UNIQUE NOT NULL,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE order_details (
detail_id SERIAL PRIMARY KEY,
order_id INTEGER NOT NULL,
product_id INTEGER NOT NULL,
quantity INTEGER NOT NULL,
price NUMERIC NOT NULL,
CONSTRAINT fk_order
FOREIGN KEY(order_id)
REFERENCES orders(order_id)
);

CREATE TABLE orders (
order_id SERIAL PRIMARY KEY,
customer_id INTEGER NOT NULL,
order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
status VARCHAR(50) NOT NULL,
total NUMERIC NOT NULL,
CONSTRAINT fk_customer
FOREIGN KEY(customer_id)
REFERENCES customers(id)
);



CREATE TABLE payments (
id SERIAL PRIMARY KEY,
order_id BIGINT NOT NULL,
amount DECIMAL(10, 2) NOT NULL,
status VARCHAR(255) NOT NULL,
payment_type VARCHAR(200) NOT NULL,
payment_date TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

## Ejecución y Despliegue

Para ejecutar cada microservicio localmente, navega al directorio raíz del servicio y ejecuta:
bash
./mvnw spring-boot:run
Asegúrate de iniciar los servicios en el orden correcto, comenzando por aquellos de los que dependen otros servicios.

## Pruebas

Utiliza herramientas como Postman o Swagger UI para probar los endpoints de cada servicio. Para endpoints protegidos, asegúrate de incluir el token JWT en el encabezado Authorization como Bearer <token>.