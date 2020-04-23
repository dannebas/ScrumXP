
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import JavaMail.MailApplication;
import dbUtils.PictureHandler;
import dbUtils.db;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Stefan
 */
public class UserProfile extends javax.swing.JFrame {

    private String author;
    private DefaultTableModel model;

    /**
     * Creates new form UserProfile
     */
    public UserProfile() {
        initComponents();
        author = SeePost.getAuthor();
        String authorName = "";
        try {
            String authorFirstName = db.getDB().fetchSingle("select FIRSTNAME from USER_PROFILE where PROFILE_ID = '" + author + "'");
            String authorLastName = db.getDB().fetchSingle("select LASTNAME from USER_PROFILE where PROFILE_ID = '" + author + "'");
            authorName = authorFirstName + " " + authorLastName;
        } catch (SQLException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        setInfo();
        addPosts();
        TableColumnModel columnmodel = tblPosts.getColumnModel();
        columnmodel.removeColumn(columnmodel.getColumn(2));
        tblPosts.setTableHeader(null);
        tblPosts.setShowGrid(false);
        scrUserPosts.getViewport().setBackground(Color.white);
        pnlBread.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Profile: " + authorName, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
    }

    public void addPosts() {

        try {
            model = (DefaultTableModel) tblPosts.getModel();
            model.setRowCount(0);
            ArrayList<HashMap<String, String>> myPosts = db.getDB().fetchRows("SELECT TITLE, DATE, POST_ID FROM POSTS WHERE AUTHOR ='" + author + "'");
            for (HashMap<String, String> aPost : myPosts) {
                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("DATE"), aPost.get("POST_ID")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred");
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"This user has no posts"});
            System.out.println(e.getMessage());
        }
    }

    private void setInfo() {
        //Set the name of the profile
        System.out.println(author);
        try {
            String qName = "select FIRSTNAME from USER_PROFILE where PROFILE_ID = '" + author + "';";
            String aName = db.getDB().fetchSingle(qName);
            String qName2 = "select LASTNAME from USER_PROFILE where PROFILE_ID = '" + author + "';";
            String aName2 = db.getDB().fetchSingle(qName2);
            lblUserNameProfile.setText(aName + " " + aName2);

            System.out.println(aName);
        } catch (SQLException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Set EMailaddress
        try {
            String qMail = "select EMAILADDRESS from USER_PROFILE where PROFILE_ID = '" + author + "';";
            String aMail = db.getDB().fetchSingle(qMail);
            Font font = lblUserEmail.getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lblUserEmail.setFont(font.deriveFont(attributes));
            lblUserEmail.setText(aMail);

        } catch (SQLException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Set image
        try {
            byte[] b = db.getDB().fetchImageBytes("select IMAGE from USER_PROFILE where PROFILE_ID = '" + author + "'");
            PictureHandler handler = new PictureHandler(110, 145);

            ImageIcon image = new ImageIcon(b);
            Image picture = handler.resize(image.getImage());
            ImageIcon resized = new ImageIcon(picture);
            lblProfileImage.setIcon(resized);

        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("Not found");
            lblProfileImage.setIcon(null);
        }

        //set phone
        try {
            String aPhone = db.getDB().fetchSingle("select PHONE from USER_PROFILE where PROFILE_ID = '" + author + "'");
            lblUserPhone.setText(aPhone);

        } catch (SQLException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("Not found");
            lblUserPhone.setText("");
        }

        try {
            //Set groups
            ArrayList<String> groups = db.getDB().fetchColumn("select GROUP_NAME FROM RESEARCH_GROUP WHERE GROUP_ID in(SELECT RESEARCH_GROUP from GROUP_MEMBERS where MEMBER = '" + author + "'" + ")");

            for (String s : groups) {
                txaGroups.append(s + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBread = new javax.swing.JPanel();
        scrUserGroups = new javax.swing.JScrollPane();
        txaGroups = new javax.swing.JTextArea();
        pnlUserInfoBackground = new javax.swing.JPanel();
        lblUserNameProfile = new javax.swing.JLabel();
        lblEmailProfile = new javax.swing.JLabel();
        lblUserEmail = new javax.swing.JLabel();
        lblNameProfile = new javax.swing.JLabel();
        lblPhoneTitle = new javax.swing.JLabel();
        lblUserPhone = new javax.swing.JLabel();
        lblProfileImage = new javax.swing.JLabel();
        scrUserPosts = new javax.swing.JScrollPane();
        tblPosts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Profile");
        setResizable(false);

        pnlBread.setBackground(new java.awt.Color(255, 255, 255));
        pnlBread.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Profile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlBread.setAlignmentX(0.0F);
        pnlBread.setAlignmentY(0.0F);
        pnlBread.setPreferredSize(new java.awt.Dimension(1022, 405));
        pnlBread.setLayout(null);

        scrUserGroups.setBackground(new java.awt.Color(255, 255, 255));
        scrUserGroups.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Research Groups", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N

        txaGroups.setBackground(new java.awt.Color(255, 255, 255));
        txaGroups.setColumns(20);
        txaGroups.setRows(5);
        txaGroups.setBorder(null);
        scrUserGroups.setViewportView(txaGroups);

        pnlBread.add(scrUserGroups);
        scrUserGroups.setBounds(10, 240, 500, 150);
        scrUserGroups.getAccessibleContext().setAccessibleName("");

        pnlUserInfoBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlUserInfoBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlUserInfoBackground.setLayout(null);

        lblUserNameProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblUserNameProfile.setForeground(new java.awt.Color(0, 0, 0));
        lblUserNameProfile.setText("UserName");
        pnlUserInfoBackground.add(lblUserNameProfile);
        lblUserNameProfile.setBounds(60, 20, 190, 16);

        lblEmailProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblEmailProfile.setForeground(new java.awt.Color(0, 0, 0));
        lblEmailProfile.setText("E-mail:");
        pnlUserInfoBackground.add(lblEmailProfile);
        lblEmailProfile.setBounds(10, 40, 40, 16);

        lblUserEmail.setBackground(new java.awt.Color(0, 0, 0));
        lblUserEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblUserEmail.setText("UserEmail");
        lblUserEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserEmailMouseClicked(evt);
            }
        });
        pnlUserInfoBackground.add(lblUserEmail);
        lblUserEmail.setBounds(60, 40, 198, 16);

        lblNameProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblNameProfile.setForeground(new java.awt.Color(0, 0, 0));
        lblNameProfile.setText("Name:");
        pnlUserInfoBackground.add(lblNameProfile);
        lblNameProfile.setBounds(10, 20, 40, 16);

        lblPhoneTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblPhoneTitle.setText("Phone:");
        pnlUserInfoBackground.add(lblPhoneTitle);
        lblPhoneTitle.setBounds(10, 60, 41, 16);

        lblUserPhone.setForeground(new java.awt.Color(0, 0, 0));
        lblUserPhone.setText("UserPhone");
        pnlUserInfoBackground.add(lblUserPhone);
        lblUserPhone.setBounds(60, 60, 220, 16);

        pnlBread.add(pnlUserInfoBackground);
        pnlUserInfoBackground.setBounds(130, 30, 380, 90);

        lblProfileImage.setForeground(new java.awt.Color(255, 255, 255));
        lblProfileImage.setText("Profile picture");
        lblProfileImage.setPreferredSize(new java.awt.Dimension(75, 75));
        pnlBread.add(lblProfileImage);
        lblProfileImage.setBounds(10, 30, 110, 145);

        scrUserPosts.setBackground(new java.awt.Color(255, 255, 255));
        scrUserPosts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Posts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N

        tblPosts.setBackground(new java.awt.Color(255, 255, 255));
        tblPosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Date", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPosts.setShowGrid(false);
        tblPosts.getTableHeader().setReorderingAllowed(false);
        tblPosts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPostsMouseClicked(evt);
            }
        });
        scrUserPosts.setViewportView(tblPosts);
        if (tblPosts.getColumnModel().getColumnCount() > 0) {
            tblPosts.getColumnModel().getColumn(0).setResizable(false);
            tblPosts.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblPosts.getColumnModel().getColumn(1).setResizable(false);
            tblPosts.getColumnModel().getColumn(2).setResizable(false);
            tblPosts.getColumnModel().getColumn(2).setPreferredWidth(0);
        }

        pnlBread.add(scrUserPosts);
        scrUserPosts.setBounds(530, 30, 480, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlBread, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBread, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblUserEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserEmailMouseClicked
        try {
            MailApplication.main(null, author);
        } catch (SQLException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblUserEmailMouseClicked

    private void tblPostsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPostsMouseClicked
        String idString = "";
        if (evt.getClickCount() == 2) {
            int id = tblPosts.getSelectedRow();
            try {
                idString = tblPosts.getModel().getValueAt(id, 2).toString();
                new SeePost(idString).setVisible(true);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Not a valid option");
            }
        }
    }//GEN-LAST:event_tblPostsMouseClicked


    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        new Profil().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void btnCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarActionPerformed
        new CalendarPrivate().setVisible(true);
    }//GEN-LAST:event_btnCalendarActionPerformed

    private void btnSeePostEducationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostEducationActionPerformed
        forum.swicthCategoryButtons(false);
        forum.addEducationForumPost();
        forum.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSeePostEducationActionPerformed

    private void btnSeePostResearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostResearchActionPerformed
        forum.addResearchForumPost();
        forum.setVisible(true);
        forum.swicthCategoryButtons(true);
        this.dispose();
    }//GEN-LAST:event_btnSeePostResearchActionPerformed

    private void btnSeePostGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostGeneralActionPerformed
        forum.addAllGeneralPost();
        forum.setVisible(true);
        forum.swicthCategoryButtons(false);
        this.dispose();
    }//GEN-LAST:event_btnSeePostGeneralActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblEmailProfile;
    private javax.swing.JLabel lblNameProfile;
    private javax.swing.JLabel lblPhoneTitle;
    private javax.swing.JLabel lblProfileImage;
    private javax.swing.JLabel lblUserEmail;
    private javax.swing.JLabel lblUserNameProfile;
    private javax.swing.JLabel lblUserPhone;
    private javax.swing.JPanel pnlBread;
    private javax.swing.JPanel pnlUserInfoBackground;
    private javax.swing.JScrollPane scrUserGroups;
    private javax.swing.JScrollPane scrUserPosts;
    private javax.swing.JTable tblPosts;
    private javax.swing.JTextArea txaGroups;
    // End of variables declaration//GEN-END:variables
}
