package com.github.nulld4201.pixelinventory.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PixelDatabase {
    private Connection connection;

    public boolean isConnected() {
        return (connection != null);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        String username = "nulld4201";
        String password = "Tnraud5756!";
        String host = "211.243.2.67";
        String database = "jinu_pixeladventure";

        connection = DriverManager.getConnection("jdbc:mariadb://" + host + ":3307/" + database, username, password);
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
