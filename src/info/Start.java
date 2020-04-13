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
    
    private static dbConnection conn;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
            
       
        conn = new dbConnection();
       // conn.fetchUsers();
        
        System.out.println(conn.fetchSingle("SELECT USER_ID, PASSWORD from USER"));
        
    }
    
}
