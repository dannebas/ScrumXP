/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import java.util.ArrayList;

/**
 *
 * @author Lukas
 */
public class User {
    private static String userID;
    private static String nameInloggad;
    private static ArrayList<String> userGroups;
    
    public User(String userID, String nameInloggad, ArrayList<String> userGroups)
    {
        this.userID = userID;
        this.nameInloggad = nameInloggad;
        this.userGroups = userGroups;
        
        
    }
    
    public static String getUser()
    {
        return userID;
    }
    public static String getName()
    {
        return nameInloggad;
    }
    
    public static ArrayList<String> getUserGroups()
    {
        return userGroups;
    }
}
