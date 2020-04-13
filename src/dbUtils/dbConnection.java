/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class dbConnection {

    private static final String url = "jdbc:sqlite:/db/db.sqlite";

    public static Connection getConnection() throws SQLException {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection established!");
            return conn;

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
        return null;
    }
}
