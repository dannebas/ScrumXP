/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;

import java.awt.Cursor;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author fabia
 */
public class SeePost extends javax.swing.JFrame {


    boolean isInformal = false;
    int numberOfComments = 0;
    Post aPost;
    String id;
    private static String author;

    /**
     * Creates new form SeePost
     *
     * @param id post id.
     */
    public SeePost(String id) {
        initComponents();
        ImageIcon profilePicture = null;
        this.id = id;
        aPost = new Post(id);
        System.out.println(id);
        try {
            profilePicture = new ImageIcon(db.getDB().fetchImageBytes("select IMAGE from USER_PROFILE where PROFILE_ID = (select AUTHOR from POSTS where POST_ID = " + id + ")"));

            if (db.getDB().fetchColumn("select POST_ID from INFORMAL_POST where POST_ID =" + id) != null) {
                isInformal = true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }


        if (isInformal) {

            lblComments.setVisible(true);
            lblComments.setText("Comments(" + numberOfComments + ")");
            lblComments.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            lblComments.setVisible(false);
        }

        lblProfileImageSeePost.setIcon(profilePicture);


        Post aPost = new Post(id);
        setLocationRelativeTo(null);
        

        lblTiltleSeePost.setText(aPost.getTitle());
        
        Font font = lblAuthorSeePost.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblAuthorSeePost.setFont(font.deriveFont(attributes));
        
        lblAuthorSeePost.setText(aPost.getAuthor());
        author = lblAuthorSeePost.getText();
        lblUploadDateSeePost.setText(aPost.getDate());

        txtAreaPostSeePost.setLineWrap(true);
        txtAreaPostSeePost.setWrapStyleWord(true);
        txtAreaPostSeePost.setEditable(false);

        loadPostContent();

        setLocationRelativeTo(null);
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
        jscrPost = new javax.swing.JScrollPane();
        txtAreaPostSeePost = new javax.swing.JTextArea();
        btnNewComment = new javax.swing.JButton();
        btnPrintPostSeePost = new javax.swing.JButton();
        btnClosePost = new javax.swing.JButton();
        lblComments = new javax.swing.JLabel();
        taNewComment = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Post");
        setMaximumSize(new java.awt.Dimension(1022, 600));
        setMinimumSize(new java.awt.Dimension(1022, 600));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnlBread.setBackground(new java.awt.Color(45, 95, 125));
        pnlBread.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBread.setAlignmentX(0.0F);
        pnlBread.setAlignmentY(0.0F);
        pnlBread.setMaximumSize(new java.awt.Dimension(1022, 600));
        pnlBread.setPreferredSize(new java.awt.Dimension(1022, 600));
        pnlBread.setLayout(null);

        lblProfileImageSeePost.setText("BILD");
        lblProfileImageSeePost.setMaximumSize(new java.awt.Dimension(110, 145));
        lblProfileImageSeePost.setMinimumSize(new java.awt.Dimension(110, 145));
        lblProfileImageSeePost.setPreferredSize(new java.awt.Dimension(110, 145));
        pnlBread.add(lblProfileImageSeePost);
        lblProfileImageSeePost.setBounds(20, 20, 110, 145);

        lblAuthorNameSeePost.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAuthorNameSeePost.setText("Author:");
        pnlBread.add(lblAuthorNameSeePost);
        lblAuthorNameSeePost.setBounds(20, 200, 51, 19);

        lblAuthorSeePost.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAuthorSeePost.setForeground(new java.awt.Color(102, 255, 153));
        lblAuthorSeePost.setText("User");
        lblAuthorSeePost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAuthorSeePostMouseClicked(evt);
            }
        });
        pnlBread.add(lblAuthorSeePost);
        lblAuthorSeePost.setBounds(80, 200, 33, 19);

        pnlPostHeaderSeePost.setBackground(new java.awt.Color(22, 52, 81));
        pnlPostHeaderSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlPostHeaderSeePost.setForeground(new java.awt.Color(255, 255, 255));
        pnlPostHeaderSeePost.setPreferredSize(new java.awt.Dimension(1024, 72));
        pnlPostHeaderSeePost.setLayout(null);

        lblTiltleSeePost.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTiltleSeePost.setForeground(new java.awt.Color(255, 255, 255));
        lblTiltleSeePost.setText("Title");
        pnlPostHeaderSeePost.add(lblTiltleSeePost);
        lblTiltleSeePost.setBounds(18, 2, 436, 34);

        lblUploadedPostSeePost.setText("Uploaded");
        pnlPostHeaderSeePost.add(lblUploadedPostSeePost);
        lblUploadedPostSeePost.setBounds(20, 40, 53, 16);

        lblUploadDateSeePost.setText("Date");
        pnlPostHeaderSeePost.add(lblUploadDateSeePost);
        lblUploadDateSeePost.setBounds(90, 40, 26, 16);

        pnlBread.add(pnlPostHeaderSeePost);
        pnlPostHeaderSeePost.setBounds(150, 20, 850, 60);

        jscrPost.setBackground(new java.awt.Color(126, 197, 239));

        txtAreaPostSeePost.setColumns(20);
        txtAreaPostSeePost.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtAreaPostSeePost.setRows(5);
        txtAreaPostSeePost.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(126, 197, 239), 1, true));
        jscrPost.setViewportView(txtAreaPostSeePost);

        pnlBread.add(jscrPost);
        jscrPost.setBounds(150, 90, 850, 300);

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
        btnNewComment.setBounds(150, 510, 130, 37);

        btnPrintPostSeePost.setBackground(new java.awt.Color(44, 95, 125));
        btnPrintPostSeePost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPrintPostSeePost.setForeground(new java.awt.Color(255, 255, 255));
        btnPrintPostSeePost.setText("Print post");
        btnPrintPostSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBread.add(btnPrintPostSeePost);
        btnPrintPostSeePost.setBounds(290, 510, 150, 37);

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
        btnClosePost.setBounds(450, 510, 107, 37);

        lblComments.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblComments.setText("New comment:");
        pnlBread.add(lblComments);
        lblComments.setBounds(150, 400, 120, 24);

        taNewComment.setColumns(20);
        taNewComment.setRows(5);
        pnlBread.add(taNewComment);
        taNewComment.setBounds(150, 430, 410, 70);

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

    private void loadPostContent() {

        try {
            txtAreaPostSeePost.setText(aPost.getDescription().indent(4));
            numberOfComments = Integer.parseInt(db.getDB().fetchSingle("select COUNT(*) from COMMENTS where POST_ID =" + id));
            if (numberOfComments != 0) {
                txtAreaPostSeePost.append("----------------------------Comments-------------------------------\n");
                loadComments();
                txtAreaPostSeePost.setCaretPosition(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeePost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadComments() {

        ArrayList<HashMap<String, String>> allComments;
        try {
            allComments = db.getDB().fetchRows("select * from COMMENTS where POST_ID =" + id);

            for (HashMap<String, String> aComment : allComments) {

                txtAreaPostSeePost.append("Date: " + aComment.get("DATE") + "\n");
                txtAreaPostSeePost.append("User: " + aComment.get("USER") + "\n");
                txtAreaPostSeePost.append("Text: \n" + aComment.get("TEXT") + "\n");
                txtAreaPostSeePost.append("---------------------------------------------------------------------\n");

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
            // System.out.println(commentText);
            // System.out.println(commentId + ", '" + User.getUser() + "', '" + commentText + "', '" + strDate + "', " + id );
            db.getDB().insert("insert into COMMENTS values (" + commentId + ", '" + User.getUser() + "', '" + commentText + "', '" + strDate + "', " + id + ")");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(NewComment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private void lblAuthorSeePostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAuthorSeePostMouseClicked
        System.out.println("1");
        OtherProfile op = new OtherProfile();
        
        op.setVisible(true);
        System.out.println("2");
        op.setLocationRelativeTo(null);
        System.out.println("3");
        this.dispose();
    }//GEN-LAST:event_lblAuthorSeePostMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClosePost;
    private javax.swing.JButton btnNewComment;
    private javax.swing.JButton btnPrintPostSeePost;
    private javax.swing.JScrollPane jscrPost;
    private javax.swing.JLabel lblAuthorNameSeePost;
    private javax.swing.JLabel lblAuthorSeePost;
    private javax.swing.JLabel lblComments;
    private javax.swing.JLabel lblProfileImageSeePost;
    private javax.swing.JLabel lblTiltleSeePost;
    private javax.swing.JLabel lblUploadDateSeePost;
    private javax.swing.JLabel lblUploadedPostSeePost;
    private javax.swing.JPanel pnlBread;
    private javax.swing.JPanel pnlPostHeaderSeePost;
    private javax.swing.JTextArea taNewComment;
    private javax.swing.JTextArea txtAreaPostSeePost;
    // End of variables declaration//GEN-END:variables
}
