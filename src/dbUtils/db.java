/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtils;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author simpa
 */
public class db {

    private static dbConnection db;

    public db() {
        try {
            String currentFolder = System.getProperty("user.dir"); //Hämta sökvägen till projektets mapp.
            String os = System.getProperty("os.name").toLowerCase(); // Kollar vilket operativsystem användaren har.
            String dbPath;
            System.out.println(currentFolder);
            if (os.contains("mac")) {
                dbPath = currentFolder + ("/db/db.sqlite"); //Sökväg för macanvändare
            } else {
                dbPath = currentFolder + ("\\db\\db.sqlite"); //Sökväg för alla andra.
                System.out.println(dbPath);
                this.db = new dbConnection(dbPath);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error");
        }
    }

    public static dbConnection getDB() {
        return db;
    }
}
