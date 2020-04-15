/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import java.sql.SQLException;

/**
 *
 * @author fabia
 */
public class Post {

private String author;

    
private String title;

private String date;

private String description;

private String id;
    

public Post(String id)
{
    this.id = id;
    
}    
    
    public String getAuthor() {
        
        try{
        author = db.getDB().fetchSingle("SELECT AUTHOR FROM POSTS WHERE POST_ID like '" + id + "'");
       
       
        }
        
        catch(SQLException ex)
        {}
        
        
        return author;
    }

    public String getTitle() {
        try{
        title = db.getDB().fetchSingle("SELECT TITLE FROM POSTS WHERE POST_ID like '" + id + "'");
       
       
        }
        
        catch(SQLException ex)
        {}
        
        return title;
    }

    public String getDate() {
        
        try{
        date = db.getDB().fetchSingle("SELECT DATE FROM POSTS WHERE POST_ID like '" + id + "'");
       
       
        }
        
        catch(SQLException ex)
        {}
        return date;
    }

    public String getDescription() {
        try{
        description = db.getDB().fetchSingle("SELECT DESCRIPTION FROM POSTS WHERE POST_ID like '" + id + "'");
       
       
        }
        
        catch(SQLException ex)
        {}
        return description;
    }

    public String getId() {
        
        return id;
    }

}


        