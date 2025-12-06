
Dental Clinic MVC - Gestión de Clínica Odontológica

Este proyecto se encuentra actualmente en desarrollo. La estructura inicial (Modelos y conexión a DB) está implementada, en proceso de crear la capa de persistencia (DAO) y las capas de servicio y controlador.

Descripción General
Este es un sistema de gestión para una clínica odontológica desarrollado con Spring Boot. Sigue la arquitectura MVC (Model-View-Controller) y utiliza una base de datos H2 para la persistencia de datos.

Tecnologías y Estructura

Framework Principal: Spring Boot
Lenguaje: Java
Base de Datos: H2 Database (local/en memoria)
Persistencia: JDBC (a través de la clase DB.java)
Estructura: Modelos de Dominio (Patient, Dentist, Address) definidos.

Estructura Implementada
Los siguientes componentes ya han sido definidos e integrados:

1. Modelos 
Patient.java
Dentist.java
Address.java

Base de Datos e Inicialización
La clase DB.java maneja la conexión a la base de datos H2. La creación de tablas se invoca al inicio de la aplicación:

public static void main(String[] args) {
    DB.createTables(); // <-- Inicializa la estructura de la base de datos
    SpringApplication.run(DentalClinicMvcApplication.class, args);
}

Configuración y Ejecución Local
Clonar el Repositorio:

git clone https://github.com/marinar2003/DentalClinicMVC.git
cd DentalClinicMVC

Base de Datos: El proyecto se conecta automáticamente a H2. La base de datos se inicializa con la llamada a DB.createTables() al iniciar.

Ejecutar la Aplicación:

./mvnw spring-boot:run 
La aplicación estará disponible en http://localhost:8080.

Próximos Avances Planificados

Para la siguiente fase del desarrollo, se planea:

Completar la Capa DAO: 
Implementar la lógica SQL completa (CREATE TABLE, INSERT, SELECT, UPDATE, DELETE) en la capa de acceso a datos.

Creación de la Capa de Servicios: 
Añadir las clases de servicio para encapsular la lógica de negocio.

Desarrollo de Controladores: 
Exponer los endpoints REST o las vistas MVC para interactuar con los datos de pacientes y odontólogos.
