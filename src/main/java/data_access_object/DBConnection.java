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
        String url = context.getInitParameter("db.url");
        String user = context.getInitParameter("db.user");
        String password = context.getInitParameter("db.password");
        connection = DriverManager.getConnection(url, user, password);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }
}
