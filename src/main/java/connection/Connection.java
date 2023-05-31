package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static Connection getConnections() {
        try {
            return (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/writer", "postgres", "56275627");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

