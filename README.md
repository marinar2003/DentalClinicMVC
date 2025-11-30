Este proyecto es un sistema de gestión para una clínica odontológica, desarrollado con Spring Boot utilizando una arquitectura basada en MVC (Model-View-Controller). 
El objetivo principal es la administración de datos de pacientes, odontólogos y sus respectivas direcciones, con una base de datos local para la persistencia de datos.

--------------------------------------------------------------------------------------------------

Tecnologías y Componentes Clave

FrameworkSpring Boot:
Facilita la configuración y ejecución de la aplicación.

ArquitecturaMVC (Model-View-Controller):
Separa la lógica de negocio, los datos (Patient, Dentist) y la interacción del usuario.

Base de DatosH2 Database (DB.java): 
Base de datos local en memoria/archivo para desarrollo y pruebas.

ModelosJava POJOs (Patient.java, Dentist.java, Address.java): 
Representan las entidades principales del sistema.

PersistenciaJava SQL (DB.java DAO Layer): 
Conexión directa a H2 y manejo de las operaciones de datos.

--------------------------------------------------------------------------------------------------
Estructura del Proyecto (Modelos Implementados)

Por ahora, los modelos de datos esenciales para la clínica están definidos:

Patient.java: Incluye nombre, apellido, DNI (cardIdentity), fecha de admisión (admissionOfDate) y su asociación con una Address.

Address.java: Define la ubicación con calle, número, localidad y provincia.

Dentist.java: Incluye nombre, apellido y número de matrícula (registration).

DB.java: Contiene la lógica para la conexión a la base de datos H2.
