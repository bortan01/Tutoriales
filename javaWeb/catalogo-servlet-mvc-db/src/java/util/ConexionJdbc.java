package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJdbc {

    private Connection conn;
    private String user = "curso";
    private String password = "javaee";
    private String url = "jdbc:derby://localhost:1527/java_productos";
    private String driverClass = "org.apache.derby.jdbc.ClientDriver";

    public ConexionJdbc(String user, String password, String url,
            String driverClass) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.driverClass = driverClass;

        conectar();
    }

    public ConexionJdbc() {

        conectar();
    }

    private void conectar() {

        try {
            Class.forName(driverClass);

            conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return conn;
    }
}
