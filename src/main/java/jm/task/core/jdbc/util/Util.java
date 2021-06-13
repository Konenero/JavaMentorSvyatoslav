package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String URL_NAME = "jdbc:mysql://localhost:3306/java_mentor?useSSL=false";
    private static String USER_NAME = "root";
    private static String PASSWORD = "root";

    public static Connection setConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL_NAME,USER_NAME,PASSWORD);
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
