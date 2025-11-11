package mvc.model.repository;

import mvc.model.entity.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 * Patrón: Data Access Object (DAO) / Repositorio.
 * Esta clase implementa el patrón DAO (Data Access Object), como un patrón de J2EE(Java2 Enterprise Edition).
 * Su única responsabilidad es encapsular el acceso a la base de datos para la entidad 'Empleado'.
 * Oculta toda la lógica SQL (SELECT, UPDATE, etc.) y la gestión de conexiones (usando DBUtils) al resto de la aplicación.
 */
public class EmpleadoRepository {

    private static final String SELECT_ALL = "SELECT * FROM empleados";
    private static final String SELECT_BY_DNI = "SELECT * FROM empleados WHERE DNI = ?";
    private static final String UPDATE_BY_DNI = "UPDATE empleados SET NOMBRE = ?, SEXO = ?, CATEGORIA = ?, ANYOS = ? WHERE DNI = ?";
    private static final String SELECT_BY_FILTRO = "SELECT * FROM empleados WHERE DNI = ? OR NOMBRE LIKE ?";

    /**
     * Obtiene una lista con todos los empleados de la base de datos.
     *
     * @return una Lista de objetos Empleado (puede estar vacía).
     * @throws RepositoryException si ocurre un error de SQL durante la consulta.
     */
    public static List<Empleado> findAll() throws RepositoryException {
        List<Empleado> empleados = new ArrayList<>();

        // try-with-resources cierra automáticamente la conexión, statement y resultset.
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stm = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = stm.executeQuery()) {


            while (rs != null && rs.next()) {


                Empleado empleado = new Empleado();
                empleado.setNombre(rs.getString("NOMBRE"));
                empleado.setDni(rs.getString("DNI"));
                empleado.setSexo(rs.getString("SEXO").charAt(0));
                empleado.setCategoria(rs.getInt("CATEGORIA"));
                empleado.setAnyos(rs.getInt("ANYOS"));
                empleados.add(empleado);
            }
            return empleados;

        } catch (SQLException e) {

            throw new RepositoryException("Error en findAll: " + e.getMessage());
        }
    }

    /**
     * Busca un empleado por su DNI (clave primaria).
     *
     * @param dni El DNI del empleado a buscar.
     * @return un Optional<Empleado> (vacío si no se encuentra, o con el empleado si se encuentra).
     * @throws RepositoryException si ocurre un error de SQL.
     */
    public static Optional<Empleado> findByDni(String dni) throws RepositoryException {

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stm = conn.prepareStatement(SELECT_BY_DNI)) {

            stm.setString(1, dni);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs != null && rs.next()) {
                    Empleado empleado = new Empleado();
                    empleado.setNombre(rs.getString("NOMBRE"));
                    empleado.setDni(rs.getString("DNI"));
                    empleado.setSexo(rs.getString("SEXO").charAt(0));
                    empleado.setCategoria(rs.getInt("CATEGORIA"));
                    empleado.setAnyos(rs.getInt("ANYOS"));
                    return Optional.of(empleado);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RepositoryException("Error en findByDni: " + e.getMessage());
        }
    }

    /**
     * Actualiza un empleado existente en la base de datos.
     *
     * @param empleado El objeto Empleado con los datos a actualizar.
     * @throws RepositoryException si la actualización falla o no se actualiza ninguna fila.
     */
    public static void updateEmpleado(Empleado empleado) throws RepositoryException {

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stm = conn.prepareStatement(UPDATE_BY_DNI)) {

            stm.setString(1, empleado.getNombre());
            stm.setString(2, String.valueOf(empleado.getSexo()));
            stm.setInt(3, empleado.getCategoria());
            stm.setInt(4, empleado.getAnyos());
            stm.setString(5, empleado.getDni());

            int num = stm.executeUpdate();

            if (num != 1) {
                throw new RepositoryException("Error: No se pudo actualizar el empleado con DNI: " + empleado.getDni());
            }
        } catch (SQLException ex) {
            throw new RepositoryException("Error en updateEmpleado: " + ex.getMessage());
        }
    }

    /**
     * Busca empleados cuyo DNI coincida exactamente o cuyo nombre contenga el filtro.
     *
     * @param filtro El DNI o parte del nombre a buscar.
     * @return Una lista de empleados (puede estar vacía).
     * @throws RepositoryException Si hay un error de SQL.
     */
    public static List<Empleado> findByFiltro(String filtro) throws RepositoryException {
        List<Empleado> empleados = new ArrayList<>();

        String likeFiltro = "%" + filtro + "%";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stm = conn.prepareStatement(SELECT_BY_FILTRO)) {

            stm.setString(1, filtro);
            stm.setString(2, likeFiltro);

            try (ResultSet rs = stm.executeQuery()) {
                while (rs != null && rs.next()) {
                    Empleado empleado = new Empleado();
                    empleado.setNombre(rs.getString("NOMBRE"));
                    empleado.setDni(rs.getString("DNI"));
                    empleado.setSexo(rs.getString("SEXO").charAt(0));
                    empleado.setCategoria(rs.getInt("CATEGORIA"));
                    empleado.setAnyos(rs.getInt("ANYOS"));
                    empleados.add(empleado);
                }
            }
        } catch (SQLException e) {
            throw new RepositoryException("Error en findByFiltro: " + e.getMessage());
        }

        return empleados;
    }
}