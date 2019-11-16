package ua.lviv.iot.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/lab3?serverTimezone=UTC&useSSL=false";
    private static final String user = "root";
    private static final String password = "2256180miya007D";

    private static Connection connection = null;

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.toString());
            }
        }
        return connection;
    }
}