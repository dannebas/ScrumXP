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
            String currentFolder = System.getProperty("user.dir"); //H�mta s�kv�gen till projektets mapp.
            String os = System.getProperty("os.name").toLowerCase(); // Kollar vilket operativsystem anv�ndaren har.
            String dbPath;
            System.out.println(currentFolder);
            System.out.println(os);
            if (os.contains("mac os x")) {
                dbPath = currentFolder + "/db/db.sqlite"; //S�kv�g f�r Mac-anv�ndare
            } else {
                dbPath = currentFolder + ("\\db\\db.sqlite"); //S�kv�g f�r Windows-anv�ndare
            }
            this.db = new dbConnection(dbPath);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error");
        }
    }

    public static dbConnection getDB() {
        return db;
    }
}
