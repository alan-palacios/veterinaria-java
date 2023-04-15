package data_access_object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;

public class DBConnection {
  private static Connection connection;

  // Constructor privado para prevenir la creación de instancias de la clase
  private DBConnection() {}

  // Método para obtener la instancia única de la clase
  public static Connection getConnection(ServletContext context) {
    if (connection == null) {
      try {
        String url = context.getInitParameter("jdbcUrl");
        String user = context.getInitParameter("jdbcUsername");
        String password = context.getInitParameter("jdbcPassword");
        // load and register JDBC driver for MySQL
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        connection = DriverManager.getConnection(url, user, password);
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }
}
