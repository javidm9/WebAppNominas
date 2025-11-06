package mvc.model.service;

import java.util.List;
import java.util.Optional;

import mvc.model.repository.EmpleadoRepository;
import mvc.model.repository.RepositoryException;
import mvc.model.entity.Empleado;


//  Patrón: Facade (Fachada).
//  Esta clase implementa el patrón Facade.
//  Actúa como una "fachada" o interfaz simple que oculta la complejidad de la
//  lógica de negocio (calcularSueldo) y el acceso a datos (los métodos del Repositorio).
//  El Controlador solo habla con esta fachada, no directamente con el Repositorio.


public class EmpleadoService {

    private static final double SUELDO_BASE = 50000.0;


    public static double calcularSueldo(Empleado empleado) {
        int anyos = empleado.getAnyos();


        return SUELDO_BASE + (5000.0 * anyos);
    }


    public static List<Empleado> findAll() throws RepositoryException {
        return EmpleadoRepository.findAll();
    }


    public static Optional<Empleado> findByDni(String dni) throws RepositoryException {
        return EmpleadoRepository.findByDni(dni);
    }


    public static void updateEmpleado(Empleado empleado) throws RepositoryException {
        EmpleadoRepository.updateEmpleado(empleado);
    }

    public static List<Empleado> buscarPorFiltro(String filtro) throws RepositoryException {
        return EmpleadoRepository.findByFiltro(filtro);
    }
}