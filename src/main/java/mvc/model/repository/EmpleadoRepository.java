package mvc.model.repository;

import mvc.model.entity.Empleado;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository {

    private static final String SELECT_ALL = "SELECT * FROM empleados";

    public static List<Empleado> findAll() throws RepositoryException {
        List<Empleado> empleados = new ArrayList<>();

        try {
            Connection conn = DBUtils.getConnection();
            java.sql.PreparedStatement stm = conn.prepareStatement(SELECT_ALL);
            java.sql.ResultSet rs = stm.executeQuery();
            while (rs != null && rs.next()) {
                Empleado empleado = new Empleado();

                String nombre = rs.getString("NOMBRE");
                String dni = rs.getString("DNI");
                String sexoStr = rs.getString("SEXO");
                int categoria = rs.getInt("CATEGORIA");
                int anyos = rs.getInt("ANYOS");
                empleado.setNombre(nombre);
                empleado.setDni(dni);
                empleado.setSexo(sexoStr.charAt(0));
                empleado.setCategoria(categoria);
                empleado.setAnyos(anyos);

                empleados.add(empleado);
            }
            return empleados;

        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
