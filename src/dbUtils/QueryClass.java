package dbUtils;

import info.Forum;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Viggo
 */
public class QueryClass 
{
    private static dbConnection conn;
    
    public QueryClass(dbConnection conn)
    {
        this.conn = conn;
    }

    /***
     * @param query
     * @param model
     * @param columns
     * @return ArrayList<HashMap<String, String>> 
     * @Description: Fetch multiple query and fill table.
     */
    public ArrayList<HashMap<String, String>> executeFetchQueryMultiple(String query, JTable model, Object[] columns)
    {
        DefaultTableModel myModel = getModel(model);
        removeRows(myModel);
        ArrayList<HashMap<String, String>> retur = null;
        
        try 
        {
            retur = conn.fetchRows(query);

            for (HashMap<String, String> aPost : retur)
            {
                myModel.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION")});
            }
        } catch (SQLException ex) 
        
        {
            JOptionPane.showMessageDialog(null, "fel!");
        }
         
        return null;
    }
    
    /***
    * @param query
    * @param columns
    * @return ArrayList<HashMap<String, String>> 
    * @Description: Fetch multiple query.
    */
    public ArrayList<HashMap<String, String>> executeFetchQueryMultiple(String query, Object[] columns)
    {
        ArrayList<HashMap<String, String>> retur = null;
        
        try 
        {
            retur = conn.fetchRows(query);
        } catch (SQLException ex) 
        
        {
            JOptionPane.showMessageDialog(null, "fel!");
        }
         
        return retur;
    }
    
    /***
    * @param query
    * @param columns
    * @return ArrayList<String>
    * @Description: Fetch columns query.
    */
    public ArrayList<String> executeFetchQueryColumn(String query)
    {
        ArrayList<String> retur = null;

        try 
        {
            retur = conn.fetchColumn(query);
        } catch (SQLException ex) 
        
        {
            JOptionPane.showMessageDialog(null, "fel!");
        }
         
        return retur;
    }
    
    /***
    * @param query
    * @param columns
    * @return ArrayList<String>
    * @Description: Fetch columns query.
    */
    public HashMap<String, String> executeFetchQueryRow(String query)
    {
        HashMap<String, String> retur = null;

        try 
        {
            retur = conn.fetchRow(query);
        } catch (SQLException ex) 
        
        {
            JOptionPane.showMessageDialog(null, "fel!");
        }
         
        return retur;
    }
   
    /**
     * @param query
     * @Returns String
     * @Description: Fetch single query.
     */
    public String executeFetchQuerySingle(String query)
    {
        String single = null;
        try 
        {
            single = conn.fetchSingle(query);
            
        } catch (SQLException ex) 
        
        {
           JOptionPane.showMessageDialog(null, "fel!");
        }
 
        return single;
    }
    
    /**
     * @param query
     * @Description: Update query.
     */
    public void executeUpdateQuery(String query)
    {
        try 
        {
            conn.update(query);
        } catch (SQLException ex) 
        
        {
           JOptionPane.showMessageDialog(null, "fel!");
        }
    }
    
    /**
     * @param query
     * @Description: Delete query.
     */
    public void executeDeleteQuery(String query)
    {
        try 
        {
            conn.delete(query);
        } catch (SQLException ex) 
        
        {
           JOptionPane.showMessageDialog(null, "fel!");
        }
    }
    
    /**
     * @param query
     * @Description: Insert query.
     */
    public void executeInsertQuery(String query)
    {
        try 
        {
            conn.insert(query);
        } catch (SQLException ex) 
        
        {
           JOptionPane.showMessageDialog(null, "fel!");
        }
    }

    /**
     * @param query
     * @param column
     * @Returns String
     */
    public int autoIncrementField(String tabel, String column)
    {
        int genereradID = 0;
       
        try 
        {
            String id = conn.getAutoIncrement(tabel, column);
            genereradID = Integer.parseInt(id);
        } catch (SQLException ex) 
        {
            System.out.print("Could not increment table");
        }
        
        return genereradID;
    }
    
    /***
     * 
     * 
     * @Methods for clearing table and converting table to (DefaultTableModel)
     * @
     */
    private DefaultTableModel getModel(JTable model)
    {
        DefaultTableModel myModel = (DefaultTableModel)model.getModel();
        return myModel;
    }
    
    //Removes all rows from selected table model.
    private void removeRows(DefaultTableModel model)
    {
        model.removeRow(0);
    }
    
}
