/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import java.sql.Connection;
import dbUtils.dbConnection;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class Start {
    
    private static Connection conn;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        try {
            conn = dbConnection.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
