package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MariaDbConnection {

    private static Connection connection;

    private static final String URL =
            "jdbc:mariadb://localhost:3306/currency_converter";
    private static final String USER = "appuser";
    private static final String PASSWORD = "password";

    private MariaDbConnection() {
        // utility class
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static void terminate() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignored) {
                // suppress; nothing we can reasonably do here
            }
        }
    }
}


