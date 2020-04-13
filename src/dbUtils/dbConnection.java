/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtils;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class dbConnection {

    private Connection conn;
    private String url = "jdbc:sqlite:";

    public dbConnection() throws SQLException {
        
            loadDriver();
            initConnection();
            
        }
    
    

    

    private void loadDriver() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Database driver not found.");
        }
    }

    private void initConnection() {
        try {
            String currentFolder = System.getProperty("user.dir");
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("mac")) {
                url = url + currentFolder + ("/db/db.sqlite"); //path for macos users
            } else {
                url = url + currentFolder + ("\\db\\db.sqlite"); //path for other users
                System.out.println(url);
            }
            conn = DriverManager.getConnection(url);
            System.out.println("Connection established!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not connect to database.");
        }

    }
    
    private void closeConnection() throws SQLException {
        try {
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Could not close the connection to the database.");
        }
    }

    private void checkConnection() throws SQLException {
        try {
            if(conn == null || conn.isClosed()) {
                    initConnection();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Could not check the connection to the database.");
        }
    }
    
    
    
     public String fetchSingle(String query) throws SQLException {
        String result = null;
        try {
            checkConnection();
            Statement sm = conn.createStatement();
            boolean hasRS = sm.execute(query);
            if (hasRS) {
                ResultSet rs = sm.getResultSet();
                if (rs.next()) {
                    result = rs.getString(1);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query failed, check statement.");
        } finally {
            closeConnection();
        }
        return result;
    }
     
     
      public ArrayList<String> fetchColumn(String query) throws SQLException {
        ArrayList<String> result = null;
        try {
            checkConnection();
            Statement sm = conn.createStatement();
            ResultSet rs = sm.executeQuery(query);
            while (rs.next()) {
                if(result==null)result = new ArrayList<String>();
                result.add(rs.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query failed, check statement.");
        } finally {
            closeConnection();
        }
        return result;
    }
    
      
    public HashMap<String, String> fetchRow(String query) throws SQLException {
        HashMap<String, String> result = null;
        try {
            checkConnection();
            Statement sm = conn.createStatement();
            ResultSet rs = sm.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int countColumns = rsmd.getColumnCount();
            int i = 1;
            if (rs.next()) {
                if(result==null)result = new HashMap<String, String>();
                while (i <= countColumns) {
                    result.put(rsmd.getColumnName(i), rs.getString(i));
                    i++;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query failed, check statement.");
        } finally {
            closeConnection();
        }
        return result;
    }
    
     public ArrayList<HashMap<String, String>> fetchRows(String query) throws SQLException {
        ArrayList<HashMap<String, String>> result = null;
        try {
            checkConnection();
            Statement sm = conn.createStatement();
            ResultSet rs = sm.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int countColumns = rsmd.getColumnCount();
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<HashMap<String, String>>();
                }
                int i = 1;
                HashMap<String, String> tempHM = new HashMap<String, String>();
                while (i <= countColumns) {
                    tempHM.put(rsmd.getColumnName(i), rs.getString(i));
                    i++;
                }
                result.add(tempHM);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query failed, check statement.");
        } finally {
            closeConnection();
        }
        return result;
    }
    
      
    /*public void fetchUsers() {
        String sql = "SELECT * FROM USER";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("USER_ID") + "\t"
                        + rs.getString("PASSWORD") + "\t");

            }

        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }*/
     
     
      private void mod(String query) throws SQLException {
        try {
            checkConnection();
            Statement sm = conn.createStatement();
            sm.executeUpdate(query);
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Query failed, check statement.");
        } finally {
            closeConnection();
        }
    }
   
     
     
     
      public void insert(String query) throws SQLException {
        if (query.toLowerCase().startsWith("insert into")) {
            mod(query);
        } else throw new SQLException("Not valid INSERT query - check your query");
    }
     
     
     
}
