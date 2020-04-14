/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

/**
 *
 * @author Lukas
 */
public class User {
    private static String userID;
    private static String nameInloggad;
    
    public User(String userID)
    {
        this.userID = userID;
        this.nameInloggad = nameInloggad;
    }
    
    public static String getUser()
    {
        return userID;
    }
    public static String getName()
    {
        return nameInloggad;
    }
}
