package com.mycompany.banking_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nitro5
 */
public class BankingConnection {
    public static Connection connect(){
        String URL = "jdbc:mysql://localhost:3306/banking";
        String username = "root";
        String password = "Nitikorn-10";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, username, password);
            Statement statement = connection.createStatement();
    }   catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BankingConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return connection;
    }
    
}