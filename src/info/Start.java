/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import dbUtils.dbConnection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Start {

    //private static dbConnection conn;

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        new db();
        /*try {
            String currentFolder = System.getProperty("user.dir"); //H�mta s�kv�gen till projektets mapp.
            String os = System.getProperty("os.name").toLowerCase(); // Kollar vilket operativsystem anv�ndaren har.
            String dbPath;
            System.out.println(currentFolder);
            if (os.contains("mac")) {
                dbPath = currentFolder + ("/db/db.sqlite"); //S�kv�g f�r macanv�ndare
            } else {
                dbPath = currentFolder + ("\\db\\db.sqlite"); //S�kv�g f�r alla andra.
                System.out.println(dbPath);
            }

            conn = new dbConnection(dbPath);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error");
        }*/

        new LogInGUI(/*db.getDB()*/).setVisible(true);
    }
}
