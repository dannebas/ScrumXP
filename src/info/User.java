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
    private String userID;
    
    public User(String userID)
    {
        this.userID = userID;
    }
    
    public String getUser()
    {
        return userID;
    }
}
