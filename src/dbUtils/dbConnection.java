/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbUtils;

import info.User;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Niklas Magnusson, adapted by Daniel Lindau
 */
public class dbConnection {

    private Connection conn;
    private final String url;

    public dbConnection(String path) throws SQLException {
        url = path;
        loadDriver();
        initConnection();
    }

    private void loadDriver() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Database driver not found. ");
        }
    }

    private void initConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + url);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Could not connect to database.");
        }

    }

    private void closeConnection() throws SQLException {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Could not close the connection to the database.");
        }
    }

    private void checkConnection() throws SQLException {
        try {
            if (conn == null || conn.isClosed()) {
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
            if (result != null) {
                JOptionPane.showMessageDialog(null, "Query failed, check statement. 1");
            }
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
                if (result == null) {
                    result = new ArrayList<String>();
                }
                result.add(rs.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query failed, check statement. 2");
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
                if (result == null) {
                    result = new HashMap<String, String>();
                }
                while (i <= countColumns) {
                    result.put(rsmd.getColumnName(i), rs.getString(i));
                    i++;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query failed, check statement. 3");
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
            JOptionPane.showMessageDialog(null, "Query failed, check statement. 4");
        } finally {
            closeConnection();
        }
        return result;
    }

    public byte[] fetchImageBytes(String query) throws SQLException {
        byte[] result = null;
        try {
            checkConnection();
            Statement sm = conn.createStatement();
            boolean hasRS = sm.execute(query);
            if (hasRS) {
                ResultSet rs = sm.getResultSet();
                if (rs.next()) {
                    result = rs.getBytes(1);
                }
            }
        } catch (SQLException e) {
            if (result != null) {
                JOptionPane.showMessageDialog(null, "Query failed, check statement. 5");
            }
        } finally {
            closeConnection();
        }
        return result;

    }

    public String getAutoIncrement(String table, String attribute) throws SQLException {
        String result = null;
        String query = "SELECT " + attribute + " FROM " + table + " ORDER BY " + attribute + " DESC";
        try {
            checkConnection();
            Statement sm = conn.createStatement();
            ResultSet rs = sm.executeQuery(query);
            if (rs.next()) {
                String inc = rs.getString(1);
                if (inc.matches("\\D+\\d+") || inc.matches("\\d+\\D+")) {
                    String[] ar = inc.split("");
                    String letters = "";
                    String numbers = "";
                    for (String anAr : ar) {
                        if (anAr.matches("\\D")) {
                            letters += anAr;
                        } else if (anAr.matches("\\d")) {
                            numbers += anAr;
                        }
                    }
                    if (numbers.matches("\\d+")) {
                        int lastInt = Integer.parseInt(numbers);
                        lastInt++;
                        if (inc.matches("\\D+\\d+")) {
                            result = letters + lastInt;
                        } else {
                            result = lastInt + letters;
                        }
                    }
                } else if (inc.matches("\\d+")) {
                    int lastInt = Integer.parseInt(inc);
                    lastInt++;
                    result = "" + lastInt;
                }
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Query failed, check statement. 6");
        } finally {
            closeConnection();
        }
        return result;
    }

    private void mod(String query) throws SQLException {
        try {
            checkConnection();
            Statement sm = conn.createStatement();
            sm.executeUpdate(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query failed, check statement. 7");
        } finally {
            closeConnection();
        }
    }

    public void insert(String query) throws SQLException {
        if (query.toLowerCase().startsWith("insert into")) {
            mod(query);
        } else {
            throw new SQLException("Not valid INSERT query - check your query 8");
        }
    }

    public void delete(String query) throws SQLException {
        if (query.toLowerCase().startsWith("delete from")) {
            mod(query);
        } else {
            throw new SQLException("Not valid DELETE query - check your query 9");
        }
    }

    public void update(String query) throws SQLException {
        if (query.toLowerCase().startsWith("update") && query.toLowerCase().contains("set")) {
            mod(query);
        } else {
            throw new SQLException("Not valid UPDATE query - check your query 10");
        }
    }

    public void saveFileToDB(File myFile, String query) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream(myFile);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        byte[] bytes = bos.toByteArray();

        String user = User.getUser();
        try {
            checkConnection();
            System.out.println(user);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setBytes(1, bytes);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saveFileToDB(File myFile) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream(myFile);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        byte[] bytes = bos.toByteArray();

        String user = User.getUser();
        try {
            checkConnection();
            System.out.println(user);
            PreparedStatement ps = conn.prepareStatement("UPDATE USER_PROFILE SET IMAGE =? WHERE PROFILE_ID = '" + User.getUser() + "'");
            ps.setBytes(1, bytes);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
