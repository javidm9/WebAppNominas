package mvc.model.service;

import java.util.List;
import java.util.Optional;

import mvc.model.repository.EmpleadoRepository;
import mvc.model.repository.RepositoryException;
import mvc.model.entity.Empleado;

public class EmpleadoService {

    public static List<Empleado> findAll() throws RepositoryException {
        return EmpleadoRepository.findAll();
    }
}
