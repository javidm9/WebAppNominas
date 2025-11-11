package mvc.model.service;

import java.util.List;
import java.util.Optional;

import mvc.model.repository.EmpleadoRepository;
import mvc.model.repository.RepositoryException;
import mvc.model.entity.Empleado;


/**
 * Patrón: Facade (Fachada).
 * Esta clase implementa el patrón Facade.
 * Actúa como una "fachada" o interfaz simple que oculta la complejidad de la
 * lógica de negocio (calcularSueldo) y el acceso a datos (los métodos del Repositorio).
 * El Controlador solo habla con esta fachada, no directamente con el Repositorio.
 */

public class EmpleadoService {

    /**
     * Sueldo base fijo para todos los empleados.
     */
    private static final double SUELDO_BASE = 50000.0;

    /**
     * Calcula el sueldo de un empleado según la fórmula:
     * sueldo = sueldoBase + 5000 * años trabajados.
     *
     * @param empleado El objeto Empleado (con los 'anyos' ya cargados).
     * @return el sueldo (double) calculado.
     */
    public static double calcularSueldo(Empleado empleado) {
        int anyos = empleado.getAnyos();
        return SUELDO_BASE + (5000.0 * anyos);
    }

    /**
     * Pide al Repositorio todos los empleados.
     *
     * @return una Lista de objetos Empleado (puede estar vacía).
     * @throws RepositoryException si ocurre un error de SQL durante la consulta.
     */
    public static List<Empleado> findAll() throws RepositoryException {
        return EmpleadoRepository.findAll();
    }

    /**
     * Pide al Repositorio un empleado por su DNI.
     *
     * @param dni El DNI del empleado a buscar.
     * @return un Optional<Empleado> (vacío si no se encuentra, o con el empleado).
     * @throws RepositoryException si ocurre un error de SQL.
     */
    public static Optional<Empleado> findByDni(String dni) throws RepositoryException {
        return EmpleadoRepository.findByDni(dni);
    }

    /**
     * Pide al Repositorio que actualice un empleado.
     *
     * @param empleado El objeto Empleado con los datos actualizados.
     * @throws RepositoryException si la actualización falla.
     */
    public static void updateEmpleado(Empleado empleado) throws RepositoryException {
        EmpleadoRepository.updateEmpleado(empleado);
    }

    /**
     * Pide al Repositorio que busque empleados por un filtro (DNI o Nombre).
     *
     * @param filtro El término de búsqueda (DNI o parte del nombre).
     * @return una Lista de objetos Empleado (puede estar vacía).
     * @throws RepositoryException si ocurre un error de SQL.
     */
    public static List<Empleado> buscarPorFiltro(String filtro) throws RepositoryException {
        return EmpleadoRepository.findByFiltro(filtro);
    }
}