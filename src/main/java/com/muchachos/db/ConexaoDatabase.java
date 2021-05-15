package com.muchachos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 30/04/2020 22:01
 * @author Ramses
 */
public class ConexaoDatabase {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexao() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/BD_MUCHACHOS?useTimezone=true&serverTimezone=America/Sao_Paulo";
        String user = "muchachos2";
        String password = "123";
        return DriverManager.getConnection(dbURL, user, password);
    }    
}
