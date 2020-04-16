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
    private static String firstName;
    private static String lastName;
    private static String phone;
    private static ArrayList<String> userGroups;
    private static boolean edu_admin;
    private static boolean res_admin;
    private static boolean admin;
    private static String eMail;

    public User(String userID) {

        this.userID = userID;
        getInfo();

    }

    public static String getUser() {
        return userID;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {

        return lastName;

    }

    public static String getName() {
        return nameInloggad;
    }

    public static String getMail() {
        return eMail;
    }

    public static String getPhone() {

        return phone;
    }

    public static ArrayList<String> getUserGroups() {
        return userGroups;
    }

    public static boolean getEduAdmin() {
        return edu_admin;
    }

    public static boolean getResAdmin() {
        return res_admin;
    }

    public static boolean getAdmin() {
        return admin;
    }

    private void getInfo() {

        //get research admin
        try {
            String firstName = db.getDB().fetchSingle("select FIRSTNAME from USER_PROFILE where PROFILE_ID = '" + userID + "'");
            String lastName = db.getDB().fetchSingle("select LASTNAME from USER_PROFILE where PROFILE_ID = '" + userID + "'");
            ArrayList<String> userGroup = db.getDB().fetchColumn("select GROUP_NAME FROM RESEARCH_GROUP WHERE GROUP_ID in(SELECT RESEARCH_GROUP from GROUP_MEMBERS where MEMBER = '" + userID + "'" + ")");
            String education_admin = db.getDB().fetchSingle("SELECT * from EDUCATION_ADMIN WHERE EDUCATION_ADMIN = '" + userID + "'");
            String research_admin = db.getDB().fetchSingle("SELECT * from RESEARCH_ADMIN WHERE RESEARCH_ADMIN = '" + userID + "'");
            String norm_admin = db.getDB().fetchSingle("SELECT * from ADMIN WHERE ADMIN = '" + userID + "'");
            String eMail = db.getDB().fetchSingle("SELECT EMAILADRESS FROM USER_PROFILE WHERE PROFILE_ID = '" + userID + "'");
            String phone = db.getDB().fetchSingle("select PHONE from USER_PROFILE where PROFILE_ID = '" + userID + "'");

            this.nameInloggad = firstName + " " + lastName;
            this.firstName = firstName;
            this.lastName = lastName;
            this.userGroups = userGroup;
            this.eMail = eMail;
            this.phone = phone;

            if (userID.equals(education_admin)) {
                this.edu_admin = true;
                System.out.println("User is edu admin");
            }
            if (userID.equals(research_admin)) {
                this.res_admin = true;
                System.out.println("User is research admin");
            }
            if (userID.equals(norm_admin)) {
                this.admin = true;
                System.out.println("User is admin");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
