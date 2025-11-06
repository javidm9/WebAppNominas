# Proyecto WebAppGestionNominas

Este es un proyecto de aplicación web Java (Servlet + JSP) desarrollado para la asignatura de Desarrollo Web en Entorno Servidor. La aplicación sigue una arquitectura MVC y gestiona los empleados de una base de datos de nóminas.

Permite realizar las siguientes operaciones:
- Listar todos los empleados.
- Calcular el salario de un empleado específico (basado en lógica de negocio).
- Buscar empleados por DNI o nombre.

---

## Patrones de Diseño Implementados

Este proyecto aplica varios patrones de diseño clave para asegurar un código limpio, mantenible y escalable.

### 1. Patrón Front Controller (Controlador Frontal)

* **Archivo:** `src/main/java/mvc/controller/EmpleadoController.java`
* **Descripción:** Se utiliza un único servlet (`EmpleadoController`) como punto de entrada para todas las peticiones (`option=...`). Este controlador centralizado recibe las solicitudes, las procesa y las redirige al componente de lógica o vista apropiado usando un `switch`.

### 2. Patrón Facade (Fachada)

* **Archivo:** `src/main/java/mvc/model/service/EmpleadoService.java`
* **Descripción:** La clase `EmpleadoService` actúa como una "fachada" para la lógica de negocio. Proporciona una interfaz simple y unificada (`findAll()`, `calcularSuelo()`, etc.) que el `EmpleadoController` puede consumir. Oculta la complejidad interna de si los datos provienen directamente del repositorio o si requieren cálculos adicionales.

### 3. Patrón Data Access Object (DAO) / Repository

* **Archivo:** `src/main/java/mvc/model/repository/EmpleadoRepository.java`
* **Descripción:** Este patrón se utiliza para abstraer y encapsular todo el acceso a la base de datos. La clase `EmpleadoRepository` es la única que contiene lógica SQL (consultas `SELECT`, `UPDATE`, etc.) y "traduce" los datos de la base de datos (un `ResultSet`) a objetos Java (`Empleado`).
