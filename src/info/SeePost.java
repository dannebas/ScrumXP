/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import dbUtils.PictureHandler;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.DefaultListModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Group 1
 */
public class SeePost extends javax.swing.JFrame {

    int numberOfComments = 0;
    Post aPost;
    String id;
    private static String author;
    private DefaultTableModel model1;
    private DefaultListModel model;
    private String[] newList;
    boolean isFormal = false;
    boolean isEducational = false;
    boolean isInformal = false;

    /**
     * Creates new form SeePost
     *
     * @param id post id.
     */
    public SeePost(String id) {

        this.id = id;
        aPost = new Post(id);
        initComponents();
        ImageIcon profilePicture = null;
        this.model = new DefaultListModel();
        TableColumnModel model1 = tblAttachedFiles.getColumnModel();
        model1.removeColumn(model1.getColumn(1));
        tblAttachedFiles.getTableHeader().setUI(null);
        scrAttachedFiles.getViewport().setBackground(Color.white);

        try {
            profilePicture = new ImageIcon(db.getDB().fetchImageBytes("select IMAGE from USER_PROFILE where PROFILE_ID = (select AUTHOR from POSTS where POST_ID = " + id + ")"));

        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        lblProfileImageSeePost.setIcon(profilePicture);
        lblTiltleSeePost.setText(aPost.getTitle());
        Font font = lblAuthorSeePost.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblAuthorSeePost.setFont(font.deriveFont(attributes));
        lblAuthorSeePost.setText(aPost.getAuthor());
        author = lblAuthorSeePost.getText();
        lblUploadDateSeePost.setText(aPost.getDate());
        txtPaneSeePost.setEditable(false);

        loadPostContent();
        txtPaneSeePost.setCaretPosition(0);
        isInformal(id);
        isFormal(id);
        isEducational(id);
         if (isInformal) {
            btnNewComment.setVisible(true);
            scrNewComment.setVisible(true);
        } else {
            scrNewComment.setVisible(false);
            btnNewComment.setVisible(false);
        }
        checkAdminType();
        setLocationRelativeTo(null);
    }

    private void isEducational(String id) {
        try { //Decides if the post is educational
            if (db.getDB().fetchColumn("select POST_ID from EDUCATION_POSTS where POST_ID ='" + id + "'") != null) {
                isEducational = true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void isFormal(String id) {
        try { //Decides if the post is formal
            if (db.getDB().fetchColumn("select POST_ID from FORMAL_POST where POST_ID ='" + id + "'") != null) {
                isFormal = true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void isInformal(String id) {
        try {
            if (db.getDB().fetchColumn("select POST_ID from INFORMAL_POST where POST_ID ='" + id + "'") != null) {
                isInformal = true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void checkAdminType() {
        if (User.getAdmin() && isInformal == true) {
            btnDeletePost.setVisible(true);
        } else if (User.getEduAdmin() && isEducational == true) {
            btnDeletePost.setVisible(true);
        } else if (User.getResAdmin() && isFormal == true) {
            btnDeletePost.setVisible(true);
        } else if (User.getUser().equals(author) && isInformal == true) {
            btnDeletePost.setVisible(true);
        } else {
            btnDeletePost.setVisible(false);
        }
    }

    public static String getAuthor() {
        return author;
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
        lblProfileImageSeePost = new javax.swing.JLabel();
        lblAuthorNameSeePost = new javax.swing.JLabel();
        lblAuthorSeePost = new javax.swing.JLabel();
        pnlPostHeaderSeePost = new javax.swing.JPanel();
        lblTiltleSeePost = new javax.swing.JLabel();
        lblUploadedPostSeePost = new javax.swing.JLabel();
        lblUploadDateSeePost = new javax.swing.JLabel();
        btnNewComment = new javax.swing.JButton();
        btnPrintPostSeePost = new javax.swing.JButton();
        btnClosePost = new javax.swing.JButton();
        scrAttachedFiles = new javax.swing.JScrollPane();
        tblAttachedFiles = new javax.swing.JTable();
        scrPostContent = new javax.swing.JScrollPane();
        txtPaneSeePost = new javax.swing.JTextPane();
        btnSaveFile = new javax.swing.JButton();
        scrNewComment = new javax.swing.JScrollPane();
        taNewComment = new javax.swing.JTextArea();
        btnDeletePost = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Post");
        setMaximumSize(new java.awt.Dimension(1022, 600));
        setMinimumSize(new java.awt.Dimension(1022, 600));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnlBread.setBackground(new java.awt.Color(255, 255, 255));
        pnlBread.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Post", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlBread.setAlignmentX(0.0F);
        pnlBread.setAlignmentY(0.0F);
        pnlBread.setMaximumSize(new java.awt.Dimension(1022, 600));
        pnlBread.setPreferredSize(new java.awt.Dimension(1022, 768));
        pnlBread.setLayout(null);

        lblProfileImageSeePost.setText("BILD");
        lblProfileImageSeePost.setMaximumSize(new java.awt.Dimension(110, 145));
        lblProfileImageSeePost.setMinimumSize(new java.awt.Dimension(110, 145));
        lblProfileImageSeePost.setPreferredSize(new java.awt.Dimension(110, 145));
        pnlBread.add(lblProfileImageSeePost);
        lblProfileImageSeePost.setBounds(20, 30, 110, 145);

        lblAuthorNameSeePost.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAuthorNameSeePost.setText("Author:");
        pnlBread.add(lblAuthorNameSeePost);
        lblAuthorNameSeePost.setBounds(20, 200, 51, 19);

        lblAuthorSeePost.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAuthorSeePost.setForeground(new java.awt.Color(44, 95, 125));
        lblAuthorSeePost.setText("User");
        lblAuthorSeePost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAuthorSeePostMouseClicked(evt);
            }
        });
        pnlBread.add(lblAuthorSeePost);
        lblAuthorSeePost.setBounds(80, 200, 33, 19);

        pnlPostHeaderSeePost.setBackground(new java.awt.Color(255, 255, 255));
        pnlPostHeaderSeePost.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Title", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlPostHeaderSeePost.setForeground(new java.awt.Color(255, 255, 255));
        pnlPostHeaderSeePost.setPreferredSize(new java.awt.Dimension(1024, 72));
        pnlPostHeaderSeePost.setLayout(null);

        lblTiltleSeePost.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTiltleSeePost.setText("Title");
        pnlPostHeaderSeePost.add(lblTiltleSeePost);
        lblTiltleSeePost.setBounds(20, 20, 436, 34);

        lblUploadedPostSeePost.setForeground(new java.awt.Color(153, 153, 153));
        lblUploadedPostSeePost.setText("Uploaded");
        pnlPostHeaderSeePost.add(lblUploadedPostSeePost);
        lblUploadedPostSeePost.setBounds(20, 50, 70, 14);

        lblUploadDateSeePost.setForeground(new java.awt.Color(153, 153, 153));
        lblUploadDateSeePost.setText("Date");
        pnlPostHeaderSeePost.add(lblUploadDateSeePost);
        lblUploadDateSeePost.setBounds(110, 50, 100, 14);

        pnlBread.add(pnlPostHeaderSeePost);
        pnlPostHeaderSeePost.setBounds(150, 20, 850, 80);

        btnNewComment.setBackground(new java.awt.Color(44, 95, 125));
        btnNewComment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNewComment.setForeground(new java.awt.Color(255, 255, 255));
        btnNewComment.setText("Post new comment");
        btnNewComment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnNewComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCommentActionPerformed(evt);
            }
        });
        pnlBread.add(btnNewComment);
        btnNewComment.setBounds(440, 710, 130, 37);

        btnPrintPostSeePost.setBackground(new java.awt.Color(44, 95, 125));
        btnPrintPostSeePost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPrintPostSeePost.setForeground(new java.awt.Color(255, 255, 255));
        btnPrintPostSeePost.setText("Print post");
        btnPrintPostSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBread.add(btnPrintPostSeePost);
        btnPrintPostSeePost.setBounds(280, 710, 150, 37);

        btnClosePost.setBackground(new java.awt.Color(44, 95, 125));
        btnClosePost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnClosePost.setForeground(new java.awt.Color(255, 255, 255));
        btnClosePost.setText("Close");
        btnClosePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnClosePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClosePostActionPerformed(evt);
            }
        });
        pnlBread.add(btnClosePost);
        btnClosePost.setBounds(160, 710, 107, 37);

        scrAttachedFiles.setBackground(new java.awt.Color(255, 255, 255));
        scrAttachedFiles.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attached Files", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N

        tblAttachedFiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title", "fileId"
            }
        ));
        tblAttachedFiles.setMinimumSize(new java.awt.Dimension(0, 0));
        tblAttachedFiles.setShowGrid(false);
        tblAttachedFiles.getTableHeader().setReorderingAllowed(false);
        scrAttachedFiles.setViewportView(tblAttachedFiles);

        pnlBread.add(scrAttachedFiles);
        scrAttachedFiles.setBounds(660, 580, 340, 120);

        scrPostContent.setBackground(new java.awt.Color(255, 255, 255));
        scrPostContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        scrPostContent.setViewportView(txtPaneSeePost);

        pnlBread.add(scrPostContent);
        scrPostContent.setBounds(150, 110, 850, 450);

        btnSaveFile.setBackground(new java.awt.Color(44, 95, 125));
        btnSaveFile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSaveFile.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveFile.setText("Save");
        btnSaveFile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFileActionPerformed(evt);
            }
        });
        pnlBread.add(btnSaveFile);
        btnSaveFile.setBounds(660, 710, 90, 37);

        scrNewComment.setBackground(new java.awt.Color(255, 255, 255));
        scrNewComment.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Comment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N

        taNewComment.setColumns(20);
        taNewComment.setRows(5);
        scrNewComment.setViewportView(taNewComment);

        pnlBread.add(scrNewComment);
        scrNewComment.setBounds(150, 580, 420, 120);

        btnDeletePost.setBackground(new java.awt.Color(44, 95, 125));
        btnDeletePost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDeletePost.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletePost.setText("Delete post");
        btnDeletePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnDeletePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePostActionPerformed(evt);
            }
        });
        pnlBread.add(btnDeletePost);
        btnDeletePost.setBounds(30, 520, 107, 37);

        getContentPane().add(pnlBread);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClosePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClosePostActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnClosePostActionPerformed


    private void btnNewCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCommentActionPerformed

        saveNewCommentToDB();

        loadPostContent();
    }//GEN-LAST:event_btnNewCommentActionPerformed

    public void appendStringTotxtPane(String str) throws BadLocationException {

        StyledDocument doc = (StyledDocument) txtPaneSeePost.getDocument();
        doc.insertString(doc.getLength(), str, null);

    }

    private void loadPostContent() { /// method that load all content in a post, the title, maintext, comments and files (embedds images to the txtPane)
        try {
            txtPaneSeePost.getStyledDocument().remove(0, txtPaneSeePost.getStyledDocument().getLength());

            txtPaneSeePost.setText(aPost.getDescription().indent(4) + "\n");

            int numberOfFiles = Integer.parseInt(db.getDB().fetchSingle("select COUNT(*) from FILES where POST =" + id));
            if (numberOfFiles > 0) {

                ArrayList<HashMap<String, String>> li = new ArrayList<>();
                li = db.getDB().fetchRows("SELECT * FROM FILES WHERE POST = '" + id + "'");
                addAttachedFilesToTable();

                for (int i = 0; i < tblAttachedFiles.getRowCount(); i++) {
                    newList = new String[tblAttachedFiles.getRowCount()];
                    newList[i] = tblAttachedFiles.getModel().getValueAt(i, 1).toString();
                    EmbeddImagesInTextPane(newList[i]);
                }
            }
            numberOfComments = Integer.parseInt(db.getDB().fetchSingle("select COUNT(*) from COMMENTS where POST_ID =" + id));
            if (numberOfComments != 0) {
                appendStringTotxtPane("\n -------------------------------------------Comments---------------------------------------------------\n");
                loadComments();
            }
        } catch (SQLException e) {
        } catch (BadLocationException er) {
        }
    }

    public void loadComments() {

        ArrayList<HashMap<String, String>> allComments;
        try {
            allComments = db.getDB().fetchRows("select * from COMMENTS where POST_ID =" + id);

            for (HashMap<String, String> aComment : allComments) {
                try {
                    appendStringTotxtPane("Date: " + aComment.get("DATE") + "\n");
                    appendStringTotxtPane("User: " + aComment.get("USER") + "\n");
                    appendStringTotxtPane("Text: \n" + aComment.get("TEXT") + "\n");
                    appendStringTotxtPane("---------------------------------------------------------------------\n");
                } catch (BadLocationException e) {
                    JOptionPane.showMessageDialog(null, "Couldn't add string");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SeePost.class.getName()).log(Level.SEVERE, null, ex);

        }

    } 

    private void saveNewCommentToDB() {
        String commentText = taNewComment.getText();
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strDate = dateFormat.format(date);
        String nextId;
        try {
            nextId = db.getDB().getAutoIncrement("COMMENTS", "COMMENT_ID");
            System.out.println(nextId);
            if (nextId == null) {
                nextId = "1";

            }
            int commentId = Integer.parseInt(nextId);

            db.getDB().insert("insert into COMMENTS values (" + commentId + ", '" + User.getUser() + "', '" + commentText + "', '" + strDate + "', " + id + ")");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(NewComment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void lblAuthorSeePostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAuthorSeePostMouseClicked
        UserProfile op = new UserProfile();
        op.setVisible(true);
        op.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lblAuthorSeePostMouseClicked

    private void btnSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFileActionPerformed
        try {
            saveFileOnComp();
        } catch (FileNotFoundException er) {
        }
    }//GEN-LAST:event_btnSaveFileActionPerformed

    private void btnDeletePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePostActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Do you want to delete this post?", "Attention", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {                                                                                           /// Method for deleting a post
            try {
                db.getDB().delete("delete from POSTS where POST_ID = '" + id + "'");

                if (("SELECT * FROM FILES WHERE POST = '" + id + "'") != null) {

                    db.getDB().delete("DELETE FROM FILES WHERE POST= '" + id + "'");

                }

                if (("SELECT * FROM INFORMAL_POST WHERE POST_ID= '" + id + "'") != null) {

                    db.getDB().delete("DELETE FROM INFORMAL_POST WHERE POST_ID = '" + id + "'");

                }

                if (("SELECT * FROM FORMAL_POST WHERE POST_ID = '" + id + "'") != null) {

                    db.getDB().delete("DELETE FROM FORMAL_POST WHERE POST_ID = '" + id + "'");

                }

                if (("SELECT * FROM EDUCATION_POSTS WHERE POST_ID = '" + id + "'") != null) {

                    db.getDB().delete("DELETE FROM EDUCATION_POSTS WHERE POST_ID = '" + id + "'");

                }

                if (("SELECT * FROM RESEARCH_POSTS WHERE POST_ID = '" + id + "'") != null) {

                    db.getDB().delete("DELETE FROM RESEARCH_POSTS WHERE POST_ID = '" + id + "'");

                }

                if (("SELECT * FROM COMMENTS WHERE POST_ID = '" + id + "'") != null) {

                    db.getDB().delete("DELETE FROM COMMENTS WHERE POST_ID = '" + id + "'");

                }
                JOptionPane.showMessageDialog(null, "The post has been deleted");

            } catch (SQLException ex) {
                Logger.getLogger(SeePost.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }

    }//GEN-LAST:event_btnDeletePostActionPerformed

    public void addAttachedFilesToTable() {  // shows which files are attached to the post by showing them on a jTable
        try {
            model1 = (DefaultTableModel) tblAttachedFiles.getModel();
            model1.setRowCount(0);

            ArrayList<HashMap<String, String>> posts = db.getDB().fetchRows("SELECT * FROM FILES WHERE POST = '" + aPost.getId() + "'");

            for (HashMap<String, String> aPost : posts) {

                String fileNameInput = aPost.get("FILENAME");

                String fileNameSubStringInput = fileNameInput.substring(fileNameInput.lastIndexOf("\\") + 1, fileNameInput.length());

                model1.addRow(new Object[]{fileNameSubStringInput, aPost.get("FILE_ID")});
            }
        } catch (SQLException ex) {

            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model1.addRow(new Object[]{"No Posts"});
        }

    }

    public void EmbeddImagesInTextPane(String fId) throws BadLocationException {  /// shows Images that are attached to the post directly on the txtpane

        String pictureName = "";

        try {

            byte[] data = db.getDB().fetchImageBytes("SELECT PATH FROM FILES WHERE FILE_ID = '" + fId + "'");

            pictureName = db.getDB().fetchSingle("SELECT FILENAME FROM FILES WHERE FILE_ID = '" + fId + "'");

            if (pictureName.contains("png") || pictureName.contains("gif") || pictureName.contains("jpg") || pictureName.contains("jpeg")) { /// This is done so that only image files are shown directly in the post
                String pictureNameInput = pictureName.substring(pictureName.lastIndexOf("\\") + 1, pictureName.length());

                ImageIcon pictureIcon = new ImageIcon(data);

                int picHeight = pictureIcon.getIconHeight();

                int picWidth = pictureIcon.getIconWidth();

                int wi = -1;

                int he = -1;

                if (picWidth > 400 || picHeight > 150) {    /// Here we control that a large picture wouldn´t cover the whole post. 

                    wi = picWidth / 2;

                    he = picHeight / 2;
                } else if (picWidth > 1000 || picHeight > 750) {
                    wi = 700;

                    he = 225;

                }

                PictureHandler handler = new PictureHandler(wi, he);

                JLabel lbl12 = new JLabel("bild");

                txtPaneSeePost.insertComponent(lbl12);

                Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
                lbl12.setBorder(border);

                Image pictureImage = pictureIcon.getImage();

                pictureImage = handler.resize(pictureImage);

                pictureIcon = new ImageIcon(pictureImage);

                lbl12.setVerticalTextPosition(JLabel.BOTTOM);
                lbl12.setHorizontalTextPosition(JLabel.CENTER);
                lbl12.setText(pictureNameInput);
                lbl12.setForeground(Color.blue);
                lbl12.setFont(new Font("Tahoma", Font.BOLD, 11));
                lbl12.setIcon(pictureIcon);
                appendStringTotxtPane("\n");

            } else {
                System.out.println("ingen imagefil");
            }
        } catch (SQLException er) {
        }

    }

    public void saveFileOnComp() throws FileNotFoundException {  /// The method used to save a attached file down to the users desktop
        String idString = "";

        String fileName = "";

        if (!(tblAttachedFiles.getSelectedRow() == -1)) {
            int id = tblAttachedFiles.getSelectedRow();

            try {
                idString = tblAttachedFiles.getModel().getValueAt(id, 1).toString();
            } catch (NullPointerException exx) {
                JOptionPane.showMessageDialog(null, "Not a Valid option");
            }

            JFileChooser chooser = new JFileChooser(new File("C:\\"));

            chooser.setDialogTitle("Save file");

            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg", "gif", "bmp"));

            chooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF-files", "pdf"));

            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Office-files", "docx", "xlsx", "pptx"));

            try {

                fileName = db.getDB().fetchSingle("SELECT FILENAME FROM FILES WHERE FILE_ID like '" + idString + "'");
            } catch (SQLException er) {
                JOptionPane.showMessageDialog(null, "Db error");
            }

            String fileNameNew = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());

            chooser.setSelectedFile(new File(fileNameNew));

            int result = chooser.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = new File(chooser.getSelectedFile().toString());
                    FileOutputStream fos = new FileOutputStream(file);
                    byte b[];
                    b = db.getDB().fetchImageBytes("SELECT PATH FROM FILES WHERE FILE_ID = '" + idString + "'");

                    fos.write(b);
                    fos.close();
                } catch (SQLException e) {
                } catch (IOException ex) {
                }
            }

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClosePost;
    private javax.swing.JButton btnDeletePost;
    private javax.swing.JButton btnNewComment;
    private javax.swing.JButton btnPrintPostSeePost;
    private javax.swing.JButton btnSaveFile;
    private javax.swing.JLabel lblAuthorNameSeePost;
    private javax.swing.JLabel lblAuthorSeePost;
    private javax.swing.JLabel lblProfileImageSeePost;
    private javax.swing.JLabel lblTiltleSeePost;
    private javax.swing.JLabel lblUploadDateSeePost;
    private javax.swing.JLabel lblUploadedPostSeePost;
    private javax.swing.JPanel pnlBread;
    private javax.swing.JPanel pnlPostHeaderSeePost;
    private javax.swing.JScrollPane scrAttachedFiles;
    private javax.swing.JScrollPane scrNewComment;
    private javax.swing.JScrollPane scrPostContent;
    private javax.swing.JTextArea taNewComment;
    private javax.swing.JTable tblAttachedFiles;
    private javax.swing.JTextPane txtPaneSeePost;
    // End of variables declaration//GEN-END:variables
}
