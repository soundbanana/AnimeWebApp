package ru.kpfu.itis.chemaev.net.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class PostgresConnectionUtil {
    private static Connection connection;

    public static Connection getConnection() {
        Properties properties = new Properties();
        try {
            properties.load(PostgresConnectionUtil.class.getResourceAsStream("/db.properties"));
            System.out.println("Properties loaded successfully");
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        if (connection == null) {
            try {Class.forName(properties.getProperty("db.driver"));
                connection = DriverManager.getConnection(
                        properties.getProperty("db.url"),
                        properties.getProperty("db.username"),
                        properties.getProperty("db.password")
                );
                System.out.println("DB loaded successfully");

            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
