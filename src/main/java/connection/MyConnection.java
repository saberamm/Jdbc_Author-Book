package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    public static Connection getConnections() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/writer", "sss", "1111");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

