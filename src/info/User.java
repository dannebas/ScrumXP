/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lukas
 */
public class User {
    private static String userID;
    private static String nameInloggad;
    private static ArrayList<String> userGroups;
    private static boolean edu_admin;
    private static boolean res_admin;
    private static boolean admin;
    
    
    
    public User(String userID)
    {
        
        this.userID = userID;
        getInfo();
        
        
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
    
    private void getInfo() {  

        //get research admin
        try {
            String name = db.getDB().fetchSingle("select NAME from USER_PROFILE where PROFILE_ID = '" + userID + "'");
            ArrayList<String> userGroup = db.getDB().fetchColumn("select RESEARCH_GROUP from GROUP_MEMBERS where MEMBER = '" + userID + "'");
            String education_admin = db.getDB().fetchSingle("SELECT * from EDUCATION_ADMIN WHERE EDUCATION_ADMIN = '" + userID + "'");
            String research_admin = db.getDB().fetchSingle("SELECT * from RESEARCH_ADMIN WHERE RESEARCH_ADMIN = '" + userID + "'");
            String norm_admin = db.getDB().fetchSingle("SELECT * from ADMIN WHERE ADMIN = '" + userID + "'");
            
            this.nameInloggad = name;
            this.userGroups = userGroup;
            
            
            if (userID.equals(education_admin)) {
                this.edu_admin = true;
                System.out.println("User is edu admin");
            } else if (userID.equals(research_admin)) {
                this.res_admin = true;
                System.out.println("User is research admin");
            } else if (userID.equals(norm_admin)) {
                this.admin = true;
                System.out.println("User is admin");
        }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
    }
}
