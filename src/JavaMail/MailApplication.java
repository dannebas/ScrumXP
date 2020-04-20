/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMail;

import dbUtils.db;
import java.io.IOException;
import java.net.URI;

import java.awt.Desktop;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MailApplication {
    public static void main(String[] args, String author) throws SQLException {
        // Get an instance of Desktop. If the platform doesn't support Desktop API an 
        // UnsupportedOperationException will be thrown.
        Desktop desktop = Desktop.getDesktop();

        try {
            // Open user-default mail client application.
            desktop.mail();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String q = "select EMAILADDRESS from USER_PROFILE where PROFILE_ID = '" + author + "';";
            String a = db.getDB().fetchSingle(q);
            
            // Open user-default mail client with the email message fields information.
            String message = "mailto:" + a + "?subject=";
            URI uri = URI.create(message);
            desktop.mail(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
            
    }
}