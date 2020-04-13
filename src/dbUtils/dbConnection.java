/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class dbConnection {

    private Connection conn;
    private static String url = "jdbc:sqlite:";

    public dbConnection() {
        try {

            String currentFolder = System.getProperty("user.dir");
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("mac")) {
                url = url + currentFolder + ("/db/db.sqlite"); //path for macos users
            } else {
                url = url + currentFolder + ("\\db\\db.sqlite"); //path for other users
                System.out.println(url);
            }
            conn = DriverManager.getConnection(url);
            System.out.println("Connection established!");

        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fetchUsers() {
        String sql = "SELECT * FROM USER";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("USER_ID") + "\t"
                        + rs.getString("PASSWORD") + "\t");

            }

        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
