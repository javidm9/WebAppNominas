package mvc.model.repository;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Patrón: Object Pool (Piscina de Objetos) y Singleton.
 *
 * Esta clase de utilidad gestiona la conexión a la base de datos.
 * Utiliza un pool de conexiones (BasicDataSource) para implementar
 * el patrón Object Pool. En lugar de crear una conexión (un objeto costoso)
 * para cada petición, gestiona una "piscina" de conexiones listas para ser
 * reutilizadas.
 **/

public class DBUtils {

    /**
     * Instancia única del pool de conexiones (Singleton).
     */
    private static BasicDataSource dataSource = null;

    /**
     * Implementa el patrón Singleton (lazy loading) para el pool.
     * Configura y devuelve el pool de conexiones (DataSource) la primera vez
     * que se solicita.
     *
     * @return El DataSource (pool) configurado.
     */
    private static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("comm.mysql.cj.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
            dataSource.setUrl("jdbc:mysql://localhost:3306/gestion_nominas?useTimezone=true&serverTimezone=UTC");
            dataSource.setInitialSize(20);
            dataSource.setMaxIdle(15);
            dataSource.setMaxTotal(20);
        }
        return dataSource;
    }

    /**
     * Método público para "pedir prestada" una conexión del pool.
     *
     * @return una conexión (Connection) de la base de datos.
     * @throws SQLException si hay un error al obtener la conexión del pool.
     */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}