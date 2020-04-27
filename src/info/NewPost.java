/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.PictureHandler;
import dbUtils.QueryClass;
import dbUtils.db;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


/**
 * @author Group 1
 */
public class NewPost extends javax.swing.JFrame {   

    private String postId;
    private DefaultListModel model;
    private int incrID;
    private File[] aListOfFiles;
    private ArrayList<File> aListForDisplayingFiles;
    private QueryClass query;
    private ArrayList<String> savedId;

    /**
     * Creates new form NewPost
     */
    public NewPost() {  //contructor used when creating a whole new post
        initComponents();
        fillCb();
        this.model = new DefaultListModel();
        cbScienceGroups.setVisible(false);
        cbEduSci.setVisible(false);
        cbCategory.setVisible(false);
        checkboxAllGroups.setVisible(false);
        buttonSave.setVisible(true);
        query = new QueryClass(db.getDB());
        incrID = query.autoIncrementField("POSTS", "POST_ID");
        aListForDisplayingFiles = new ArrayList<>();
        setLocationRelativeTo(null);
        btnRemoveFileEdit.setVisible(false);
        btnRemoveFile.setVisible(true);
    }

    public NewPost(String postId) {   //contructor used when editing a post
        initComponents();
        this.model = new DefaultListModel();
        this.postId = postId;
        fillTitleandMainText();
        findPostLocation(postId);
        buttonPost.setVisible(false);
        incrID = Integer.parseInt(postId);
        query = new QueryClass(db.getDB());
        aListForDisplayingFiles = new ArrayList<>();
        setLocationRelativeTo(null);
        
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        
        
        try{
        String betterFileName = "";
        String fileName = "";
        list = db.getDB().fetchRows("SELECT * FROM FILES WHERE POST =" + postId);
       System.out.println(list.size());
            lstDisplayingAttachedFiles.setModel(model);
        savedId = new ArrayList<>();
       
        for(HashMap<String, String> oneAttachedFile: list)
        {
            savedId.add(oneAttachedFile.get("FILE_ID"));
            fileName = oneAttachedFile.get("FILENAME");
             betterFileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
             model.addElement(betterFileName);
             
        }
        }catch(SQLException s)
                {}
        catch(NullPointerException ee)
        {}
        
        btnRemoveFile.setVisible(false);
        btnRemoveFileEdit.setVisible(true);
    }

    private void clear() {
        textTitle.setText("");
        textMain.setText("");
    }

    private void findPostLocation(String idString) {
        try {
            String q1 = db.getDB().fetchSingle("SELECT POST_ID FROM INFORMAL_POSTS WHERE POST_ID = " + idString);
            if (q1 != null) {
                cbSubject.addItem("Informal");
            } else {
                cbSubject.addItem("Formal");
                String q2 = db.getDB().fetchSingle("SELECT CATEGORY_NAME FROM CATEGORY WHERE CATEGORY_ID = (SELECT CATEGORY FROM FORMAL_POST WHERE POST_ID = " + idString + ")");
                cbCategory.addItem(q2);

                String q3 = db.getDB().fetchSingle("SELECT POST_ID FROM EDUCATION_POSTS WHERE POST_ID = " + idString);
                if (q3 != null) {
                    cbEduSci.addItem("Education");
                } else {
                    cbEduSci.addItem("Science");
                    String q4 = db.getDB().fetchSingle("SELECT RESEARCH_GROUP FROM RESEARCH_POSTS WHERE POST_ID = " + idString);
                    String q5 = db.getDB().fetchSingle("SELECT GROUP_NAME FROM RESEARCH_GROUP WHERE GROUP_ID = " + q4);
                    cbScienceGroups.addItem(q5);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void fillCb() {
        cbSubject.addItem("Informal");
        if (User.getEduAdmin() || User.getResAdmin()) {
            cbSubject.addItem("Formal");
            try {
                String postCategory = "SELECT CATEGORY_NAME FROM CATEGORY";
                ArrayList<String> categories = new ArrayList<String>();
                categories = db.getDB().fetchColumn(postCategory);
                for (String category : categories) {
                    cbCategory.addItem(category);
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            if (User.getEduAdmin()) {
                cbEduSci.addItem("Education");
            }
            if (User.getResAdmin()) {
                cbEduSci.addItem("Science");
                cbEduSci.setSelectedItem("Science");
                try {
                    String category = "SELECT GROUP_NAME FROM RESEARCH_GROUP";
                    ArrayList<String> subjects = new ArrayList<String>();
                    subjects = db.getDB().fetchColumn(category);
                    for (String subject : subjects) {
                        cbScienceGroups.addItem(subject);
                    }
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBread = new javax.swing.JPanel();
        pnlCategory = new javax.swing.JPanel();
        cbSubject = new javax.swing.JComboBox<>();
        cbCategory = new javax.swing.JComboBox<>();
        cbEduSci = new javax.swing.JComboBox<>();
        cbScienceGroups = new javax.swing.JComboBox<>();
        checkboxAllGroups = new javax.swing.JCheckBox();
        scrAttachedFiles = new javax.swing.JScrollPane();
        lstDisplayingAttachedFiles = new javax.swing.JList<>();
        btnRemoveFile = new javax.swing.JButton();
        buttonAttach = new javax.swing.JButton();
        textTitle = new javax.swing.JTextField();
        buttonClear = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonPost = new javax.swing.JButton();
        scrDescription = new javax.swing.JScrollPane();
        textMain = new javax.swing.JEditorPane();
        btnRemoveFileEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnlBread.setBackground(new java.awt.Color(255, 255, 255));
        pnlBread.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Post", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlBread.setPreferredSize(new java.awt.Dimension(800, 768));
        pnlBread.setLayout(null);

        pnlCategory.setBackground(new java.awt.Color(255, 255, 255));
        pnlCategory.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlCategory.setForeground(new java.awt.Color(0, 0, 0));
        pnlCategory.setLayout(null);

        cbSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubjectActionPerformed(evt);
            }
        });
        pnlCategory.add(cbSubject);
        cbSubject.setBounds(20, 50, 160, 26);

        cbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoryActionPerformed(evt);
            }
        });
        pnlCategory.add(cbCategory);
        cbCategory.setBounds(190, 50, 160, 26);

        cbEduSci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEduSciActionPerformed(evt);
            }
        });
        pnlCategory.add(cbEduSci);
        cbEduSci.setBounds(360, 50, 160, 26);

        cbScienceGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbScienceGroupsActionPerformed(evt);
            }
        });
        pnlCategory.add(cbScienceGroups);
        cbScienceGroups.setBounds(530, 50, 160, 26);

        checkboxAllGroups.setBackground(new java.awt.Color(255, 255, 255));
        checkboxAllGroups.setText("Publish to all groups");
        checkboxAllGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxAllGroupsActionPerformed(evt);
            }
        });
        pnlCategory.add(checkboxAllGroups);
        checkboxAllGroups.setBounds(530, 20, 150, 24);

        pnlBread.add(pnlCategory);
        pnlCategory.setBounds(30, 40, 710, 110);

        scrAttachedFiles.setBackground(new java.awt.Color(255, 255, 255));
        scrAttachedFiles.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attached Files", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        scrAttachedFiles.setForeground(new java.awt.Color(0, 0, 0));

        lstDisplayingAttachedFiles.setBackground(new java.awt.Color(102, 102, 102));
        lstDisplayingAttachedFiles.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lstDisplayingAttachedFiles.setForeground(new java.awt.Color(0, 0, 0));
        scrAttachedFiles.setViewportView(lstDisplayingAttachedFiles);

        pnlBread.add(scrAttachedFiles);
        scrAttachedFiles.setBounds(30, 570, 220, 120);

        btnRemoveFile.setBackground(new java.awt.Color(44, 95, 125));
        btnRemoveFile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRemoveFile.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveFile.setText("Remove file");
        btnRemoveFile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRemoveFile.setPreferredSize(new java.awt.Dimension(96, 32));
        btnRemoveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFileActionPerformed(evt);
            }
        });
        pnlBread.add(btnRemoveFile);
        btnRemoveFile.setBounds(30, 700, 90, 37);

        buttonAttach.setBackground(new java.awt.Color(44, 95, 125));
        buttonAttach.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonAttach.setForeground(new java.awt.Color(255, 255, 255));
        buttonAttach.setText("Attach file");
        buttonAttach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAttachActionPerformed(evt);
            }
        });
        pnlBread.add(buttonAttach);
        buttonAttach.setBounds(270, 580, 104, 37);

        textTitle.setBackground(new java.awt.Color(255, 255, 255));
        textTitle.setForeground(new java.awt.Color(0, 0, 0));
        textTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Title", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        textTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTitleActionPerformed(evt);
            }
        });
        pnlBread.add(textTitle);
        textTitle.setBounds(30, 160, 710, 50);

        buttonClear.setBackground(new java.awt.Color(44, 95, 125));
        buttonClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonClear.setForeground(new java.awt.Color(255, 255, 255));
        buttonClear.setText("Clear text");
        buttonClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });
        pnlBread.add(buttonClear);
        buttonClear.setBounds(410, 580, 94, 37);

        buttonSave.setBackground(new java.awt.Color(44, 95, 125));
        buttonSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonSave.setForeground(new java.awt.Color(255, 255, 255));
        buttonSave.setText("Save");
        buttonSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        pnlBread.add(buttonSave);
        buttonSave.setBounds(550, 580, 70, 37);

        buttonPost.setBackground(new java.awt.Color(44, 95, 125));
        buttonPost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonPost.setForeground(new java.awt.Color(255, 255, 255));
        buttonPost.setText("Post");
        buttonPost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPostActionPerformed(evt);
            }
        });
        pnlBread.add(buttonPost);
        buttonPost.setBounds(670, 580, 59, 37);

        scrDescription.setBackground(new java.awt.Color(255, 255, 255));
        scrDescription.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        scrDescription.setForeground(new java.awt.Color(0, 0, 0));

        textMain.setBackground(new java.awt.Color(255, 255, 255));
        textMain.setBorder(null);
        textMain.setForeground(new java.awt.Color(0, 0, 0));
        scrDescription.setViewportView(textMain);

        pnlBread.add(scrDescription);
        scrDescription.setBounds(30, 230, 710, 310);

        btnRemoveFileEdit.setBackground(new java.awt.Color(44, 95, 125));
        btnRemoveFileEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRemoveFileEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveFileEdit.setText("Remove file");
        btnRemoveFileEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRemoveFileEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFileEditActionPerformed(evt);
            }
        });
        pnlBread.add(btnRemoveFileEdit);
        btnRemoveFileEdit.setBounds(30, 700, 90, 40);

        getContentPane().add(pnlBread);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbScienceGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbScienceGroupsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbScienceGroupsActionPerformed

    private void cbEduSciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEduSciActionPerformed
        showCbEduSci();
    }//GEN-LAST:event_cbEduSciActionPerformed

    private void cbSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubjectActionPerformed
        String choice = cbSubject.getSelectedItem().toString();
        if (choice.equals("Formal")) {
            cbEduSci.setVisible(true);
            cbCategory.setVisible(true);
            if (User.getResAdmin()) {
                cbScienceGroups.setVisible(true); // Makes ScienceGroups visible if Research-Admin
            }
        } else {
            cbEduSci.setVisible(false);
            cbScienceGroups.setVisible(false);
            cbCategory.setVisible(false); // Hides Category when its a Informal post
        }
    }//GEN-LAST:event_cbSubjectActionPerformed

    private void textTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTitleActionPerformed

    private void buttonPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPostActionPerformed
        if (Validation.checkTextFieldEmpty(textTitle)) {            // the method of creating a post
            try {
                String autoID;
                autoID = db.getDB().getAutoIncrement("POSTS", "POST_ID");

                if (autoID == null) {
                    autoID = "1";
                }

                Calendar cal = Calendar.getInstance();
                Date date = cal.getTime();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                String date1 = format1.format(date);

                String title = textTitle.getText();
                String mainText = textMain.getText();
                db.getDB().insert("INSERT INTO POSTS VALUES ('" + autoID + "','" + title + "','" + mainText + "','" + date1 + "','" + User.getUser() + "')");
                // Added insert values depending on the selected options in the ColumnBox
                if (cbSubject.getSelectedItem().toString().equals("Informal")) {
                    db.getDB().insert("INSERT INTO INFORMAL_POST VALUES ('" + autoID + "')");
                } else if (cbSubject.getSelectedItem().toString().equals("Formal")) {
                    String categoryNumber = db.getDB().fetchSingle("SELECT CATEGORY_ID FROM CATEGORY WHERE CATEGORY_NAME = '" + cbCategory.getSelectedItem().toString() + "'");
                    db.getDB().insert("INSERT INTO FORMAL_POST VALUES ('" + autoID + "','" + categoryNumber + "')");
                    if (cbEduSci.getSelectedItem().toString().equals("Science")) {
                        //if checkbox 'Publish to all groups is selected'.
                        String researchGroup = db.getDB().fetchSingle("SELECT GROUP_ID FROM RESEARCH_GROUP WHERE GROUP_NAME = '" + cbScienceGroups.getSelectedItem().toString() + "'");
                        if (checkboxAllGroups.isSelected()) {
                            db.getDB().insert("INSERT INTO RESEARCH_POSTS VALUES ('" + autoID + "','" + researchGroup + "'," + true + ")");
                        }
                        if (!checkboxAllGroups.isSelected()) {
                            db.getDB().insert("INSERT INTO RESEARCH_POSTS VALUES ('" + autoID + "','" + researchGroup + "'," + false + ")");
                        }
                    } else if (cbEduSci.getSelectedItem().toString().equals("Education")) {
                        db.getDB().insert("INSERT INTO EDUCATION_POSTS VALUES ('" + autoID + "')");
                    }
                }
                JOptionPane.showMessageDialog(null, "Post added!");
                clear();
            } catch (SQLException e) {
                System.err.println(e);
            }

            addFilesToPost();
        }
    }//GEN-LAST:event_buttonPostActionPerformed

    private void addFilesToPost() {  // Method for adding files to a post

        if (model.getSize() > 0) {
            for (File oneFile : aListForDisplayingFiles) {
                String path = oneFile.getAbsolutePath();
                
                int fileID = query.autoIncrementField("FILES", "FILE_ID");
              
                
               
                query.executeUploadQueryFiles(oneFile, "INSERT INTO FILES VALUES(" + fileID + ",'" + path + "', ? ," + incrID + ")");
            }
        }

    }

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        clear();
    }//GEN-LAST:event_buttonClearActionPerformed

    private void cbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoryActionPerformed

    private void fillTitleandMainText() {
        try {
            String title = db.getDB().fetchSingle("SELECT TITLE FROM POSTS WHERE POST_ID = " + postId);
            String mainText = db.getDB().fetchSingle("SELECT DESCRIPTION FROM POSTS WHERE POST_ID = " + postId);
            textTitle.setText(title);
            textMain.setText(mainText);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        try {                                        //Method for saving editing updates for a post
            String title = textTitle.getText();
            String mainText = textMain.getText();

            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format1.format(date);

            db.getDB().update("UPDATE POSTS SET DATE = " + "'" + date1 + "'" + " WHERE POST_ID = " + postId);
            db.getDB().update("UPDATE POSTS SET TITLE = " + "'" + title + "'" + " WHERE POST_ID = " + postId);
            db.getDB().update("UPDATE POSTS SET DESCRIPTION = " + "'" + mainText + "'" + " WHERE POST_ID = " + postId);

            JOptionPane.showMessageDialog(null, "Post edited!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        addFilesToPost();

    }//GEN-LAST:event_buttonSaveActionPerformed

    private void fillListWithAttachedFiles() {
        PictureHandler fileHandler = new PictureHandler(1, 1);
        aListOfFiles = fileHandler.openFiles();
        lstDisplayingAttachedFiles.setModel(model);
        if (aListOfFiles != null) {
            for (int i = 0; i < aListOfFiles.length; i++) {
                aListForDisplayingFiles.add(aListOfFiles[i]);
                String path = aListOfFiles[i].getAbsolutePath();

                String pathInsert = path.substring(path.lastIndexOf("\\") + 1, path.length());
                model.addElement(pathInsert);
            }
        }
    }

    private void removeListItem() {
                                        // This method is used when creating a new post and you regrett adding a file to the post, here you will remove the file from the list that is used to add files to the database when you create a post.
        if (!lstDisplayingAttachedFiles.isSelectionEmpty()) {
            int i = lstDisplayingAttachedFiles.getSelectedIndex();
            model.removeElementAt(i);
            aListForDisplayingFiles.remove(i);
        }

    }

    private void buttonAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAttachActionPerformed

        fillListWithAttachedFiles();
    }//GEN-LAST:event_buttonAttachActionPerformed

    private void btnRemoveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFileActionPerformed
        removeListItem();
    }//GEN-LAST:event_btnRemoveFileActionPerformed

    private void checkboxAllGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxAllGroupsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxAllGroupsActionPerformed

    private void btnRemoveFileEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFileEditActionPerformed
       
        if (!lstDisplayingAttachedFiles.isSelectionEmpty()) {      // this method is used when editing a post and you want to delete files attached to it
            int i = lstDisplayingAttachedFiles.getSelectedIndex();
            
            int result = JOptionPane.showConfirmDialog(null, "Delete the file from the post?"); // worth noting that if you press yes on the confirm dialog the files are deleted from the database
            
            if(result == 0)
            {    
            model.removeElementAt(i);
           try{
             
            db.getDB().delete("DELETE FROM FILES WHERE FILE_ID =" + savedId.get(i));
            savedId.remove(i);
            }
            catch(SQLException e)
            {}   
        }
       
    
        
        }
        
       
    }//GEN-LAST:event_btnRemoveFileEditActionPerformed

    private void showCbEduSci() {
        String choice = cbEduSci.getSelectedItem().toString();
        if (choice.equals("Science")) {
            cbScienceGroups.setVisible(true);
            checkboxAllGroups.setVisible(true);
        } else {
            cbScienceGroups.setVisible(false);
            checkboxAllGroups.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemoveFile;
    private javax.swing.JButton btnRemoveFileEdit;
    private javax.swing.JButton buttonAttach;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonPost;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbEduSci;
    private javax.swing.JComboBox<String> cbScienceGroups;
    private javax.swing.JComboBox<String> cbSubject;
    private javax.swing.JCheckBox checkboxAllGroups;
    private javax.swing.JList<String> lstDisplayingAttachedFiles;
    private javax.swing.JPanel pnlBread;
    private javax.swing.JPanel pnlCategory;
    private javax.swing.JScrollPane scrAttachedFiles;
    private javax.swing.JScrollPane scrDescription;
    private javax.swing.JEditorPane textMain;
    private javax.swing.JTextField textTitle;
    // End of variables declaration//GEN-END:variables

}
