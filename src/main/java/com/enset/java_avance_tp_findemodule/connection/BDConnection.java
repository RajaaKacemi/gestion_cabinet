package com.enset.java_avance_tp_findemodule.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {

    private static Connection connection;

    static String url = "jdbc:postgresql://localhost:5432/Cabinet";
    static String user = "postgres";
    static String password = "admin";

    static {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion réussie !");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
