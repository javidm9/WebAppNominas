package mvc.model.repository;

import mvc.model.entity.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository {

    private static final String SELECT_ALL = "SELECT * FROM empleados";

    public static List<Empleado> findAll() throws RepositoryException {
        List<Empleado> empleados = new ArrayList<>();

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
}